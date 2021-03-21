package com.codegym.furama_resort.repositories;

import com.codegym.furama_resort.models.ResortService;
import com.codegym.furama_resort.models.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;

@Repository
public interface ResortServiceRepository extends JpaRepository<ResortService, String> {
    Page<ResortService> findAll(Pageable pageable);
    Page<ResortService> findAllByNameContains(String name, Pageable pageable);
    Page<ResortService> findAllByServiceType(ServiceType serviceType, Pageable pageable);
}
