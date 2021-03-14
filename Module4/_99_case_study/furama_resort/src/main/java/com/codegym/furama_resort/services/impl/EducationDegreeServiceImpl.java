package com.codegym.furama_resort.services.impl;

import com.codegym.furama_resort.models.EducationDegree;
import com.codegym.furama_resort.repositories.EducationDegreeRepository;
import com.codegym.furama_resort.services.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    EducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public EducationDegree findById(int id) {
        return educationDegreeRepository.findById(id).orElse(null);
    }
}
