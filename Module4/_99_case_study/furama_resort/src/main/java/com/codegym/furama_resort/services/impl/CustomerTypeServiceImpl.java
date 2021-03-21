package com.codegym.furama_resort.services.impl;

import com.codegym.furama_resort.models.CustomerType;
import com.codegym.furama_resort.repositories.CustomerTypeRepository;
import com.codegym.furama_resort.services.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
