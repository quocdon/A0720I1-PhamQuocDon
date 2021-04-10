package com.codegym.blog.services;

import com.codegym.blog.models.AppRole;
import com.codegym.blog.models.AppUser;
import com.codegym.blog.models.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserRoleService {
    Set<UserRole> findByAppUser(AppUser appUser);
}
