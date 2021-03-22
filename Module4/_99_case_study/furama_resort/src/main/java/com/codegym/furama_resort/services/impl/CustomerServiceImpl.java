package com.codegym.furama_resort.services.impl;

import com.codegym.furama_resort.models.Customer;
import com.codegym.furama_resort.repositories.CustomerRepository;
import com.codegym.furama_resort.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAllByIdOrName(String search, Pageable pageable) {
        return customerRepository.findAllByIdCardContainsOrNameContains(search, search, pageable);
    }

    @Override
    public boolean existById(String id) {
        return customerRepository.existsById(id);
    }
}
