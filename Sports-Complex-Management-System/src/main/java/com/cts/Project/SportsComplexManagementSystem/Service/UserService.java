package com.cts.Project.SportsComplexManagementSystem.Service;

import com.cts.Project.SportsComplexManagementSystem.Model.User;
import com.cts.Project.SportsComplexManagementSystem.Repository.UserRepository;
import com.cts.Project.SportsComplexManagementSystem.UserDefinedExceptions.NotExistInDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        if(users.isEmpty()) {
            throw new NotExistInDatabase("No users found in Database");
        }
        return users;
    }


    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotExistInDatabase("user Id not found in Database: " + id));

    }

    public User addUser(User user) {
        return userRepository.save(user);
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User logIn(String mailId,String password)
    {
        List<User> users = getUsers();

        for(User user:users)
        {
            if(user.getMailId().equals(mailId) && user.getPassword().equals(password))
            {
                return user;
            }
        }
        throw new NotExistInDatabase("Your password or email is incorrect");
    }
}


















//    public User updateUser(long userId,User user) {
//
//        User existingUser = getUserById(userId);
//        if(user.getName() != null){
//            existingUser.setName(user.getName());
//        }
//        if (user.getPassword() != null){
//            existingUser.setPassword(user.getPassword());
//        }
//        if(user.getPhoneNo() != null){
//            existingUser.setPhoneNo(user.getPhoneNo());
//        }
//        if (user.getMailId() != null){
//            existingUser.setMailId(user.getMailId());
//        }
//
//        return userRepository.save(existingUser);
//    }