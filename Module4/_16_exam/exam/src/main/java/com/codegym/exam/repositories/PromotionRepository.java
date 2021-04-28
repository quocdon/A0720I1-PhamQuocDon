package com.codegym.exam.repositories;

import com.codegym.exam.models.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Integer> {
    List<Promotion> findAllByDiscount(long discount);
    List<Promotion> findAllByStartDate(String date);
    List<Promotion> findAllByEndDate(String date);
//    List<Promotion> findAllByDiscountOrStartDateOrAndEndDate(Long discount, String startDate, String endDate);
    List<Promotion> findAllByStartDateOrEndDate(String startDate, String endDate);

}
