package com.codegym.furama_resort.services.impl;

import com.codegym.furama_resort.models.ResortService;
import com.codegym.furama_resort.models.ServiceType;
import com.codegym.furama_resort.repositories.ResortServiceRepository;
import com.codegym.furama_resort.services.ResortServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ResortServiceServiceImpl implements ResortServiceService {
    @Autowired
    private ResortServiceRepository resortServiceRepository;

    @Override
    public Page<ResortService> findAll(Pageable pageable) {
        return resortServiceRepository.findAll(pageable);
    }

    @Override
    public Page<ResortService> findAllByServiceType(ServiceType serviceType, Pageable pageable) {
        return resortServiceRepository.findAllByServiceType(serviceType, pageable);
    }

    @Override
    public Page<ResortService> findAllByIdOrNameContains(String search, Pageable pageable) {
        return resortServiceRepository.findAllByIdContainsOrNameContains(search, search, pageable);
    }

    @Override
    public ResortService save(ResortService resortService) {
        return resortServiceRepository.save(resortService);
    }

    @Override
    public ResortService findById(String id) {
        return resortServiceRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existById(String id) {
        return resortServiceRepository.existsById(id);
    }

    @Override
    public Page<ResortService> findByName(String name, Pageable pageable) {
        return resortServiceRepository.findAllByNameContains(name, pageable);
    }
}
