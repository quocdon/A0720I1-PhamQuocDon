package com.codegym.furama_resort.services;

import com.codegym.furama_resort.models.AppUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppUserService {
    List<AppUser> findAll();
    AppUser findByUsername(String username);
    void save(AppUser appUser);
    void delete(String username);
    boolean existById(String username);
}
