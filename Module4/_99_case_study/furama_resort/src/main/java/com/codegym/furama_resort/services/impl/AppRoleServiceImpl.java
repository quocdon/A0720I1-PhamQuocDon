package com.codegym.furama_resort.services.impl;

import com.codegym.furama_resort.models.AppRole;
import com.codegym.furama_resort.repositories.AppRoleRepository;
import com.codegym.furama_resort.services.AppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRoleServiceImpl implements AppRoleService {
    @Autowired
    AppRoleRepository appRoleRepository;

    @Override
    public List<AppRole> findAll() {
        return appRoleRepository.findAll();
    }

    @Override
    public AppRole findById(int id) {
        return appRoleRepository.findById(id).orElse(null);
    }
}
