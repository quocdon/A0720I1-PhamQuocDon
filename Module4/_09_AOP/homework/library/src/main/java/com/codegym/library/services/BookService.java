package com.codegym.library.services;

import com.codegym.library.models.Book;
import com.codegym.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> findAll();
    Book findById(int id);
    void save(Book book);
    void delete(int id);
}
