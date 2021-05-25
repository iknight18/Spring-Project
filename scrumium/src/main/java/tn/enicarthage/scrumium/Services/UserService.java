package tn.enicarthage.scrumium.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enicarthage.scrumium.Repositories.SprintRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(rollbackFor = Exception.class) 
    public String saveDto(UserDto userDto) { 
        userDto.setPassword(bCryptPasswordEncoder
            .encode(userDto.getPassword())); 
        return save(new User(userDto)).getId(); 
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String addUser(User user) {
            if(userRepository.findByName(user.getName()).isPresent())
                throw new IllegalStateException("Project With name = "+ user.getName()+" exists Already!");
                userRepository.save(user);
            return "User "+user.getName()+" Added !";
    }
}
