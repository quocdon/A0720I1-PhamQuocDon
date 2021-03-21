package com.codegym.furama_resort.services;

import com.codegym.furama_resort.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findAll();
    User findByUsername(String username);
    void save(User user);
    void delete(String username);
    boolean existById(String username);
}
