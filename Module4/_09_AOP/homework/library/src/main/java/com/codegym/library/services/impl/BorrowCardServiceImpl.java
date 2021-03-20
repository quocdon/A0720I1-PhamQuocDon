package com.codegym.library.services.impl;

import com.codegym.library.models.BorrowCard;
import com.codegym.library.repositories.BookRepository;
import com.codegym.library.repositories.BorrowCardRepository;
import com.codegym.library.services.BorrowCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowCardServiceImpl implements BorrowCardService {
    @Autowired
    BorrowCardRepository borrowCardRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<BorrowCard> findAll() {
        return borrowCardRepository.findAll();
    }

    @Override
    public BorrowCard findById(int id) {
        return borrowCardRepository.findById(id).orElse(null);
    }

    @Override
    public BorrowCard save(BorrowCard borrowCard) {
        return borrowCardRepository.save(borrowCard);
    }

    @Override
    public void delete(int id) {
        borrowCardRepository.deleteById(id);
    }
}
