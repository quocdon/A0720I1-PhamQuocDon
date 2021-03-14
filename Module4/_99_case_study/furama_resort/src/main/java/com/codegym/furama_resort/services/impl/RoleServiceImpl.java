package com.codegym.furama_resort.services.impl;

import com.codegym.furama_resort.models.Role;
import com.codegym.furama_resort.repositories.RoleRepository;
import com.codegym.furama_resort.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(int id) {
        return roleRepository.findById(id).orElse(null);
    }
}
