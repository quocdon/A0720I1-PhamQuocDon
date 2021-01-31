package service.contract;

import model.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> findAll();
    void save(ContractDetail contractDetail);
}
