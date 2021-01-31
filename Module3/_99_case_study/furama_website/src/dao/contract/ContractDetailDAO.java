package dao.contract;

import model.ContractDetail;

import java.sql.SQLException;
import java.util.List;

public interface ContractDetailDAO {
    void insertContractDetail(ContractDetail contractDetail) throws SQLException;
    List<ContractDetail> selectByContractId(String id) throws SQLException;
    List<ContractDetail> selectAll() throws SQLException;
}
