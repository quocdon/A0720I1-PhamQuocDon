package dao.contract.impl;

import dao.contract.ContractDAO;
import dao.contract.ContractDetailDAO;
import model.AttachService;
import model.ContractDetail;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailDAOImpl implements ContractDetailDAO {
    private static final String INSERT_CONTRACT_DETAIL = "insert into contract_detail(contract_id, attach_service_id, quantity) values (?, ?, ?)";
    private static final String SELECT_BY_CONTRACT_ID = "select * from contract_detail where contract_id = ?";
    private static final String SELECT_ALL = "select * from contract_detail";


    @Override
    public void insertContractDetail(ContractDetail contractDetail) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_DETAIL);
        preparedStatement.setString(1, contractDetail.getContractId());
        preparedStatement.setInt(2, contractDetail.getAttachServiceId());
        preparedStatement.setInt(3, contractDetail.getQuantity());
        preparedStatement.executeUpdate();
    }

    @Override
    public List<ContractDetail> selectByContractId(String contractId) throws SQLException {
        List<ContractDetail> contractDetailList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_CONTRACT_ID);
        preparedStatement.setString(1, contractId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("contract_detail_id");
            int attachServiceId = resultSet.getInt("attach_service_id");
            int quantity = resultSet.getInt("quantity");
            ContractDetail contractDetail = new ContractDetail(id, contractId, attachServiceId, quantity);
            contractDetailList.add(contractDetail);
        }
        return contractDetailList;
    }

    @Override
    public List<ContractDetail> selectAll() throws SQLException {
        List<ContractDetail> contractDetailList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("contract_detail_id");
            String contractId = resultSet.getString("contract_id");
            int attachServiceId = resultSet.getInt("attach_service_id");
            int quantity = resultSet.getInt("quantity");
            ContractDetail contractDetail = new ContractDetail(id, contractId, attachServiceId, quantity);
            contractDetailList.add(contractDetail);
        }
        return null;
    }
}
