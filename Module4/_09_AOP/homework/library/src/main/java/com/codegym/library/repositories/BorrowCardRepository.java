package com.codegym.library.repositories;

import com.codegym.library.models.BorrowCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowCardRepository extends JpaRepository<BorrowCard, Integer> {
}
