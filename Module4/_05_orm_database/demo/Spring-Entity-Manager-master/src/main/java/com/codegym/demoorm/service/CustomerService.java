package com.codegym.demoorm.service;


import com.codegym.demoorm.model.Customer;
import java.util.List;

public interface CustomerService{
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}