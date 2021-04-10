package com.codegym.blog.repositories;

import com.codegym.blog.models.AppRole;
import com.codegym.blog.models.AppUser;
import com.codegym.blog.models.UserRole;
import com.codegym.blog.models.UserRoleKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleKey> {
    Set<UserRole> findByAppUser(AppUser appUser);
}
