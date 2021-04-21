package com.codegym.furama_resort.services;

import com.codegym.furama_resort.models.AppUser;
import com.codegym.furama_resort.models.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public
interface UserRoleService {
    List<UserRole> findAll();
    void save(UserRole userRole);
    Set<UserRole> findByAppUser(AppUser appUser);
    void deleteAllByUsername(String username);
}
