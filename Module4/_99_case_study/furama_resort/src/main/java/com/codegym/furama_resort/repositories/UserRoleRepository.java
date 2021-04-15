package com.codegym.furama_resort.repositories;

import com.codegym.furama_resort.models.AppUser;
import com.codegym.furama_resort.models.UserRole;
import com.codegym.furama_resort.models.UserRoleKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleKey> {
    Set<UserRole> findByAppUser(AppUser appUser);
}
