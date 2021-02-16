package dao.contract;

import model.Contract;
import model.Service;

import java.sql.SQLException;
import java.util.List;

public interface ContractDAO {
    List<Contract> selectAll() throws SQLException;
    Contract selectServiceById(String id) throws SQLException;
    void insertContract(Contract contract) throws SQLException;
    boolean updateContract(Contract contract) throws SQLException;
    boolean deleteContract(int id);
}
