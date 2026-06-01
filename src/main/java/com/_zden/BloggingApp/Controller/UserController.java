package com._zden.BloggingApp.Controller;

import com._zden.BloggingApp.DTOs.CreateUserDTO;
import com._zden.BloggingApp.DTOs.LoginUser;
import com._zden.BloggingApp.DTOs.UserDTO;
import com._zden.BloggingApp.Entities.User;
import com._zden.BloggingApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/v1/auth/register")
    public ResponseEntity<User> createUser(@RequestBody CreateUserDTO user) throws Exception {
        return userService.createUser(user);
    }

    @PostMapping("/v1/auth/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginUser user) throws Exception {
        return userService.loginUser(user);
    }

    @GetMapping("v1/admin/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }
}
