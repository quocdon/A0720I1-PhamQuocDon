package com.codegym.furama_resort.services;

import com.codegym.furama_resort.models.ResortService;
import com.codegym.furama_resort.models.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ResortServiceService {
    Page<ResortService> findAll(Pageable pageable);
    Page<ResortService> findAllByServiceType(ServiceType serviceType, Pageable pageable);
    Page<ResortService> findAllByIdOrNameContains(String search, Pageable pageable);
    ResortService save(ResortService resortService);
    ResortService findById(String id);
    boolean existById(String id);
    Page<ResortService> findByName(String name, Pageable pageable);
}
