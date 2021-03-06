package com.codegym.furama_resort.services.impl;

import com.codegym.furama_resort.models.Contract;
import com.codegym.furama_resort.repositories.ContractRepository;
import com.codegym.furama_resort.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public void delete(int id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findAllByIdOrCustomerName(String search, Pageable pageable) {
        int id;
        try {
            id = Integer.parseInt(search);
        } catch (Exception e) {
            id = 0;
        }
        return contractRepository.findAllByIdOrCustomer_Name(id, "%" + search + "%", pageable);

    }
}
