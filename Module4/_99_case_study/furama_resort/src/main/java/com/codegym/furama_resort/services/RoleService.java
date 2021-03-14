package com.codegym.furama_resort.services;

import com.codegym.furama_resort.models.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    List<Role> findAll();
    Role findById(int id);
}
