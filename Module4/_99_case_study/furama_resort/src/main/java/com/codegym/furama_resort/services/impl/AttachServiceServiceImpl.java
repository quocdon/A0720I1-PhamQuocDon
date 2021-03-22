package com.codegym.furama_resort.services.impl;

import com.codegym.furama_resort.models.AttachService;
import com.codegym.furama_resort.repositories.AttachServiceRepository;
import com.codegym.furama_resort.services.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceServiceImpl implements AttachServiceService {
    @Autowired
    AttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public AttachService findById(int id) {
        return attachServiceRepository.findById(id).orElse(null);
    }
}
