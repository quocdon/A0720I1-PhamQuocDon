package com.codegym.furama_resort.services.impl;

import com.codegym.furama_resort.models.Position;
import com.codegym.furama_resort.repositories.PositionRepository;
import com.codegym.furama_resort.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position findById(int id) {
        return positionRepository.findById(id).orElse(null);
    }
}
