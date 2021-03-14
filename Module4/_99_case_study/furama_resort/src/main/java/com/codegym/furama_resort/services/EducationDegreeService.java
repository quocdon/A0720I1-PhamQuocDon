package com.codegym.furama_resort.services;

import com.codegym.furama_resort.models.EducationDegree;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EducationDegreeService {
    List<EducationDegree> findAll();

    EducationDegree findById(int id);
}
