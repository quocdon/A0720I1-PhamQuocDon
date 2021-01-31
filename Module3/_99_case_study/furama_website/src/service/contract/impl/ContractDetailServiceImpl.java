package service.contract.impl;

import dao.contract.ContractDetailDAO;
import dao.contract.impl.ContractDetailDAOImpl;
import model.ContractDetail;
import service.contract.ContractDetailService;

import java.sql.SQLException;
import java.util.List;

public class ContractDetailServiceImpl implements ContractDetailService {
    ContractDetailDAO contractDetailDAO = new ContractDetailDAOImpl();
    @Override
    public List<ContractDetail> findAll() {
        try {
            return contractDetailDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(ContractDetail contractDetail) {
        try {
            contractDetailDAO.insertContractDetail(contractDetail);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
