package com.codegym.library.services;

import com.codegym.library.models.BorrowCard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BorrowCardService {
    List<BorrowCard> findAll();
    BorrowCard findById(int id);
    BorrowCard save(BorrowCard borrowCard);
    void delete(int id);
}
