package com.codegym.library.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    private String name;
    @NotNull
    @Min(0)
    private int qty;
    @OneToMany(mappedBy = "book")
    private List<BorrowCard> borrowCards;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public List<BorrowCard> getBorrowCards() {
        return borrowCards;
    }

    public void setBorrowCards(List<BorrowCard> borrowCards) {
        this.borrowCards = borrowCards;
    }
}
