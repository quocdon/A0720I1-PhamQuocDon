package com.codegym.furama_resort.repositories;

import com.codegym.furama_resort.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByIdCardContainsOrNameContains(String idCard, String name, Pageable pageable);
}
