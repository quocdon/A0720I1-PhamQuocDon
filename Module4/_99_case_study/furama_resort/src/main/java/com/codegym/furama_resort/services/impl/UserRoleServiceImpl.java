package com.codegym.furama_resort.services.impl;

import com.codegym.furama_resort.models.AppUser;
import com.codegym.furama_resort.models.UserRole;
import com.codegym.furama_resort.repositories.UserRoleRepository;
import com.codegym.furama_resort.services.CustomerService;
import com.codegym.furama_resort.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public void save(UserRole userRole) {
        userRoleRepository.save(userRole);
    }

    @Override
    public Set<UserRole> findByAppUser(AppUser appUser) {
        return userRoleRepository.findByAppUser(appUser);
    }
}
