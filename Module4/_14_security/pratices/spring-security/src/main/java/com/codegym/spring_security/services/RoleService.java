package com.codegym.spring_security.services;

import com.codegym.spring_security.models.AppRole;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface RoleService {
    List<AppRole> findAll();
}
