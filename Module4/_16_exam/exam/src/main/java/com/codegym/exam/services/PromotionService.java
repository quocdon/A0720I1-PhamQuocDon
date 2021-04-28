package com.codegym.exam.services;

import com.codegym.exam.models.Promotion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PromotionService {
    List<Promotion> findAll();

    void save(Promotion promotion);

    void delete(int id);

    List<Promotion> findByDiscount(long discount);

    List<Promotion> findByStartDate(String startDate);

    List<Promotion> findByEndDate(String endDate);

    List<Promotion> findByDate(String search);
}
