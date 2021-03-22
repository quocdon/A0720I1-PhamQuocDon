package com.codegym.furama_resort.services;

import com.codegym.furama_resort.models.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ContractService {
    Page<Contract> findAll(Pageable pageable);
    Contract findById(int id);
    Contract save(Contract contract);
    void delete(int id);
}
