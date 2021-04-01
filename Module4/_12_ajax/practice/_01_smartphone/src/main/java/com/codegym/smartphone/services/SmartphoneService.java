package com.codegym.smartphone.services;

import com.codegym.smartphone.models.Smartphone;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SmartphoneService {
    List<Smartphone> findAll();
    Smartphone findById(int id);
    Smartphone save(Smartphone smartphone);
    Smartphone remove(int id);
}
