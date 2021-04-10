package com.codegym.spring_security.repositories;

import com.codegym.spring_security.models.AppUser;
import com.codegym.spring_security.models.UserRole;
import com.codegym.spring_security.models.UserRoleKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleKey> {
    List<UserRole> findByUser(AppUser user);
}
