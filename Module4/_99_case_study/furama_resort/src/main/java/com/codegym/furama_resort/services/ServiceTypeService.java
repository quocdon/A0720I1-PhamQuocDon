package com.codegym.furama_resort.services;

import com.codegym.furama_resort.models.ServiceType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceTypeService {
    List<ServiceType> findAll();

    ServiceType findById(int id);
}
