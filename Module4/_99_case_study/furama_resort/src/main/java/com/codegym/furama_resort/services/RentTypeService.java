package com.codegym.furama_resort.services;

import com.codegym.furama_resort.models.RentType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RentTypeService {
    List<RentType> findAll();
}
