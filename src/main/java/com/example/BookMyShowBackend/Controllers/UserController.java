package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.Model.User;
import com.example.BookMyShowBackend.Services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping()
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}
