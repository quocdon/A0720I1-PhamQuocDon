package com.codegym.furama_resort.services;

import com.codegym.furama_resort.models.AppRole;
import com.codegym.furama_resort.models.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppRoleService {
    List<AppRole> findAll();
    AppRole findById(int id);
}
