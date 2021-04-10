package com.codegym.spring_security.repositories;

import com.codegym.spring_security.models.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<AppRole, Integer> {
}
