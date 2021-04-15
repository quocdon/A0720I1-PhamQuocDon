package com.codegym.furama_resort.repositories;

import com.codegym.furama_resort.models.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Integer> {
}
