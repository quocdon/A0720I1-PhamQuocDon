package com.codegym.spring_security.services;

import com.codegym.spring_security.models.AppUser;
import com.codegym.spring_security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public AppUser save(AppUser appUser) {
        return userRepository.save(appUser);
    }

    @Override
    public AppUser findByUsername(String username) {
        return userRepository.findById(username).orElse(null);
    }
}
