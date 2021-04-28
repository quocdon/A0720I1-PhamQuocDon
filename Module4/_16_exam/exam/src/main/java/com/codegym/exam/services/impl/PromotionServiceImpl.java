package com.codegym.exam.services.impl;

import com.codegym.exam.models.Promotion;
import com.codegym.exam.repositories.PromotionRepository;
import com.codegym.exam.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {
    @Autowired
    PromotionRepository promotionRepository;

    @Override
    public List<Promotion> findAll() {
        return promotionRepository.findAll();
    }

    @Override
    public void save(Promotion promotion) {
        promotionRepository.save(promotion);
    }

    @Override
    public void delete(int id) {
        promotionRepository.deleteById(id);
    }

    @Override
    public List<Promotion> findByDiscount(long discount) {
        return promotionRepository.findAllByDiscount(discount);
    }

    @Override
    public List<Promotion> findByStartDate(String startDate) {
        return promotionRepository.findAllByStartDate(startDate);
    }

    @Override
    public List<Promotion> findByEndDate(String endDate) {
        return promotionRepository.findAllByEndDate(endDate);
    }

    @Override
    public List<Promotion> findByDate(String search) {
       return promotionRepository.findAllByStartDateOrEndDate(search, search);
    }
}
