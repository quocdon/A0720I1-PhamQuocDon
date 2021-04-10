package com.codegym.blog.services;

import com.codegym.blog.models.AppRole;
import com.codegym.blog.models.AppUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppRoleService {
    AppRole findById(int id);
}
