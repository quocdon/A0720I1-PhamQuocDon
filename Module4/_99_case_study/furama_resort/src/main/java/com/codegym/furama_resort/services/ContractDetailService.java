package com.codegym.furama_resort.services;

import com.codegym.furama_resort.models.ContractDetail;
import com.codegym.furama_resort.models.ContractDetailKey;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContractDetailService {
    List<ContractDetail> findAll();
    List<ContractDetail> findAllByContractId(int id);
    void save(ContractDetail contractDetail);
    void save(List<ContractDetail> contractDetailList);
    void deleteByContractId(int id);
    boolean contractDetailKeyIsExist(int contractId, int attachServiceId);
    ContractDetail findById(ContractDetailKey id);
    void delete(ContractDetail contractDetail);
}
