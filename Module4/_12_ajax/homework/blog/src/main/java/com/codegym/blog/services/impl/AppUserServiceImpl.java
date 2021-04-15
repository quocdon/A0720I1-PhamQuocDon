package com.codegym.blog.services.impl;

import com.codegym.blog.models.AppUser;
import com.codegym.blog.repositories.AppUserRepository;
import com.codegym.blog.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public AppUser findByUsername(String username) {
        return appUserRepository.findById(username).orElse(null);
    }
}
