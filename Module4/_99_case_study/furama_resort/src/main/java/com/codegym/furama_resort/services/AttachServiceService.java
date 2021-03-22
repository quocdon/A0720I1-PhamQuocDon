package com.codegym.furama_resort.services;

import com.codegym.furama_resort.models.AttachService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttachServiceService {
    List<AttachService> findAll();
    AttachService findById(int id);
}
