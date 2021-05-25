package tn.enicarthage.scrumium.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tn.enicarthage.scrumium.Domain.User;
import tn.enicarthage.scrumium.Repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String addUser(User user) {
            if(userRepository.findByUsername(user.getUsername()).isEmpty())
                throw new IllegalStateException("Project With name = "+ user.getUsername()+" exists Already!");
                user.setPassword(encoder.encode(user.getPassword()));
                userRepository.save(user);
            return "User "+user.getUsername()+" Added !";
    }
}
