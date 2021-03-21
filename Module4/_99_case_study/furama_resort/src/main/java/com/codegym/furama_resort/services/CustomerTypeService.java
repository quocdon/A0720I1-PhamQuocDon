package com.codegym.furama_resort.services;

import com.codegym.furama_resort.models.CustomerType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerTypeService {
    List<CustomerType> findAll();
}
