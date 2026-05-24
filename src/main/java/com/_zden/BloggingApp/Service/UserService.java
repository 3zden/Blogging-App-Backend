package com._zden.BloggingApp.Service;

import com._zden.BloggingApp.Entities.UserEntity;
import com._zden.BloggingApp.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    authTest auth = new authTest();
    UserRepo userRepo;
    public UserEntity createUser(UserEntity user) throws Exception {
        user.setPassword(auth.hash(user.getPassword()));
        userRepo.save(user);
        return user;
    }
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }
}
