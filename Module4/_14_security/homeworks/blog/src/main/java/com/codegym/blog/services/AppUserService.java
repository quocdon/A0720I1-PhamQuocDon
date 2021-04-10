package com.codegym.blog.services;

import com.codegym.blog.models.AppUser;
import org.springframework.stereotype.Service;

@Service
public interface AppUserService {
    AppUser findByUsername(String username);
}
