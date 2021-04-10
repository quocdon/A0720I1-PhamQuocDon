package com.codegym.spring_security.services;

import com.codegym.spring_security.models.UserRole;
import com.codegym.spring_security.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService{
    @Autowired
    UserRoleRepository userRoleRepository;
    @Override
    public void save(UserRole userRole) {
        userRoleRepository.save(userRole);
    }
}
