package com._zden.BloggingApp.Controller;

import com._zden.BloggingApp.Entities.UserEntity;
import com._zden.BloggingApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/v1/users")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) throws Exception {
        UserEntity user1 = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
}
