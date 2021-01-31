package service.contract.impl;

import dao.contract.ContractDAO;
import dao.contract.impl.ContractDAOImpl;
import model.Contract;
import model.Service;
import service.IdComparator;
import service.contract.ContractService;
import service.customer.CustomerService;
import service.customer.impl.CustomerServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContractServiceImpl implements ContractService {
    ContractDAO contractDAO = new ContractDAOImpl();
    CustomerService customerService = new CustomerServiceImpl();
    @Override
    public List<Contract> findAll() {
        try {
            return contractDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Contract getById(String id) {
        try {
            return contractDAO.selectServiceById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Contract contract) {
        try {
            contractDAO.insertContract(contract);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public boolean update(Contract contract) {
        return false;
    }

    @Override
    public List<Contract> searchByCustomerName(String name) {
        List<Contract> result = new ArrayList<>();
        List<Contract> contractList = this.findAll();
        for (Contract contract : contractList){
            if (customerService.getById(contract.getCustomerId()).getName().contains(name));
            result.add(contract);
        }
        return result;
    }

    @Override
    public String generateId() {
        List<String> idList = new ArrayList<>();
        List<Contract> contractList = new ArrayList<>();
        try {
            contractList = contractDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (contractList.size() == 0){
            return "HD-0001";
        }

        for (Contract contract : contractList){
            idList.add(contract.getId());
        }

        IdComparator idComparator = new IdComparator();
        Collections.sort(idList, idComparator);
        String lastId = idList.get(idList.size()-1);
        String newId = "HD-".concat(String.format("%04d", Integer.parseInt(lastId.substring(3)) + 1));
        return newId;
    }
}
