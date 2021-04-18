package com.codegym.furama_resort.services.impl;

import com.codegym.furama_resort.models.ContractDetail;
import com.codegym.furama_resort.models.ContractDetailKey;
import com.codegym.furama_resort.repositories.ContractDetailRepository;
import com.codegym.furama_resort.services.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    ContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public List<ContractDetail> findAllByContractId(int id) {
        return contractDetailRepository.findAllByContract_Id(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void save(List<ContractDetail> contractDetailList) {
        for (ContractDetail contractDetail : contractDetailList){
            contractDetailRepository.save(contractDetail);
        }
    }

    @Override
    public void deleteByContractId(int id) {
        contractDetailRepository.deleteAllByContract_Id(id);
    }

    @Override
    public boolean contractDetailKeyIsExist(int contractId, int attachServiceId) {
        for (ContractDetail contractDetail : contractDetailRepository.findAll()){
            if (contractDetail.getContract().getId() == contractId && contractDetail.getAttachService().getId() == attachServiceId){
                return true;
            }
        }
        return false;
    }

    @Override
    public ContractDetail findById(ContractDetailKey id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(ContractDetail contractDetail) {
        contractDetailRepository.delete(contractDetail);
    }
}
