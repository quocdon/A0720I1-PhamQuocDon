package com.codegym.furama_resort.services;

import com.codegym.furama_resort.models.Position;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PositionService {
    List<Position> findAll();

    Position findById(int id);
}
