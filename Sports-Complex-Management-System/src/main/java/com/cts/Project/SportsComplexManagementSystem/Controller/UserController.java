package com.cts.Project.SportsComplexManagementSystem.Controller;

import com.cts.Project.SportsComplexManagementSystem.Model.User;
import com.cts.Project.SportsComplexManagementSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private final UserService userservice;

    @Autowired
    public UserController(UserService userservice) {
        this.userservice = userservice;
    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        return userservice.getUsers();
    }


    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userservice.getUserById(userId);
    }

    @CrossOrigin
    @PostMapping("/adduser")
    public User createUser(@RequestBody User user) {
        return userservice.addUser(user);
    }

    @CrossOrigin
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userservice.deleteUser(userId);
    }

    @CrossOrigin
    @GetMapping("/{mailId}/{password}")
    public User logIn(@PathVariable String mailId,@PathVariable String password)
    {
        User user = userservice.logIn(mailId,password);
        return user;
    }
}














//@CrossOrigin
//@PutMapping("/{userId}")
//public User updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
//    return userservice.updateUser(userId, updatedUser);
//}