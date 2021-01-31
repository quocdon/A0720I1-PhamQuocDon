package service.contract;

import model.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> findAll();
    Contract getById(String id);
    void save(Contract contract);
    boolean remove(int id);
    boolean update(Contract contract);
    List<Contract> searchByCustomerName(String name);
    String generateId();
}
