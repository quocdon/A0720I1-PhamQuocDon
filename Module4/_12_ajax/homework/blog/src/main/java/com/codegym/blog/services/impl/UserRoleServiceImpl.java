package com.codegym.blog.services.impl;

import com.codegym.blog.models.AppRole;
import com.codegym.blog.models.AppUser;
import com.codegym.blog.models.UserRole;
import com.codegym.blog.repositories.UserRoleRepository;
import com.codegym.blog.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public Set<UserRole> findByAppUser(AppUser appUser) {
        return userRoleRepository.findByAppUser(appUser);
    }
}
