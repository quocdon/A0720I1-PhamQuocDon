package com.codegym.spring_security.services;

import com.codegym.spring_security.models.UserRole;
import org.springframework.stereotype.Service;

@Service
public interface UserRoleService {
    void save(UserRole userRole);
}
