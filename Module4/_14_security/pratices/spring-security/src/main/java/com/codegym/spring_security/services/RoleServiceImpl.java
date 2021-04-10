package com.codegym.spring_security.services;

import com.codegym.spring_security.models.AppRole;
import com.codegym.spring_security.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<AppRole> findAll() {
        return roleRepository.findAll();
    }
}
