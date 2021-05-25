package tn.enicarthage.scrumium.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.scrumium.Domain.User;
import tn.enicarthage.scrumium.Services.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();}
    @PostMapping
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
