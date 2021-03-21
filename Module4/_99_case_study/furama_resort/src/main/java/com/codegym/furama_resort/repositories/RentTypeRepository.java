package com.codegym.furama_resort.repositories;

import com.codegym.furama_resort.models.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentTypeRepository extends JpaRepository<RentType, Integer> {
}
