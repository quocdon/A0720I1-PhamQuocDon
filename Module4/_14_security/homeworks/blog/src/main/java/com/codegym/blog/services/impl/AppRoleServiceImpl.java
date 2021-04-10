package com.codegym.blog.services.impl;

import com.codegym.blog.models.AppRole;
import com.codegym.blog.models.AppUser;
import com.codegym.blog.repositories.AppRoleRepository;
import com.codegym.blog.services.AppRoleService;
import com.codegym.blog.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRoleServiceImpl implements AppRoleService {
    @Autowired
    AppRoleRepository appRoleRepository;

    @Override
    public AppRole findById(int id) {
        return appRoleRepository.findById(id).orElse(null);
    }

}
