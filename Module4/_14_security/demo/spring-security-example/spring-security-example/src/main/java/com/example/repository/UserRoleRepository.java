package com.example.repository;

import com.example.entity.AppUser;
import com.example.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    Set<UserRole> findByAppUser(AppUser appUser);
}
