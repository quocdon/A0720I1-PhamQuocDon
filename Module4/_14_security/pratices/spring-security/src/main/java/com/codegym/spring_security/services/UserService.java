package com.codegym.spring_security.services;

import com.codegym.spring_security.models.AppUser;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    AppUser save(AppUser appUser);
    AppUser findByUsername(String username);
}
