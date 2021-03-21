package com.codegym.furama_resort.services.impl;

import com.codegym.furama_resort.models.RentType;
import com.codegym.furama_resort.repositories.RentTypeRepository;
import com.codegym.furama_resort.services.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
