package com._zden.BloggingApp.Service;

import com._zden.BloggingApp.Entities.User;
import com._zden.BloggingApp.Repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    authTest auth = new authTest();
    UserRepo userRepo;
    public User createUser(User user) throws Exception {
        user.setPassword(auth.hash(user.getPassword()));
        userRepo.save(user);
        return user;
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();

    }
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }
}
