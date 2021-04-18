package com.codegym.furama_resort.repositories;

import com.codegym.furama_resort.models.ContractDetail;
import com.codegym.furama_resort.models.ContractDetailKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractDetailRepository extends JpaRepository<ContractDetail, ContractDetailKey> {
    List<ContractDetail> findAllByContract_Id(int contractId);
    void deleteAllByContract_Id(int contractId);
}
