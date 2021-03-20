package com.codegym.library.models;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
public class BorrowCard {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    public BorrowCard() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
