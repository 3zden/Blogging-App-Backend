package com._zden.BloggingApp.Service;

import com._zden.BloggingApp.Entities.UserDetailsImpl;
import com._zden.BloggingApp.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        if (userRepo.findByEmail(email) != null){
            return new UserDetailsImpl(userRepo.findByEmail(email));
        }
        System.out.println("User not found");
        throw new UsernameNotFoundException("user not found");

    }
}
