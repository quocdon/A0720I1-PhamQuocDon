package com.codegym.customer.services;

import com.codegym.customer.models.Province;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProvinceService {
    List<Province> findAll();
    Province findById(int id);
    void save(Province province);
    void delete(int id);
}
