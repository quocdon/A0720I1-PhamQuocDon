package dao.contract.impl;

import dao.contract.ContractDAO;
import model.Contract;
import model.Service;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContractDAOImpl implements ContractDAO {
    private static final String SELECT_ALL = "Select * from contract";
    private static final String SELECT_BY_ID = "Select * from contract where contract_id = ?";
    private static final String INSERT_CONTRACT = "Insert into contract(contract_id, contract_start_date, contract_end_date, contract_deposit, contract_amount, employee_id, customer_id, service_id) values (?,?,?,?,?,?,?,?);";
    private static final String UPDATE_CONTRACT = "update contract set contract_start_date = ?, contract_end_date = ?, contract_deposit = ?, contract_amount = ?, employee_id = ?, customer_id = ?, service_id = ? where contract_id = ?";

    @Override
    public List<Contract> selectAll() throws SQLException {
        List<Contract> contractList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String id = resultSet.getString("contract_id");
            Date startDate = resultSet.getDate("contract_start_date");
            Date endDate = resultSet.getDate("contract_end_date");
            double deposit = resultSet.getDouble("contract_deposit");
            double amount = resultSet.getDouble("contract_amount");
            int employeeId = resultSet.getInt("employee_id");
            String customerId = resultSet.getString("customer_id");
            String serviceId = resultSet.getString("service_id");
            contractList.add(new Contract(id, startDate, endDate, deposit, amount, employeeId, customerId, serviceId));
        }
        return contractList;
    }

    @Override
    public Contract selectServiceById(String id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Date startDate = resultSet.getDate("contract_start_date");
            Date endDate = resultSet.getDate("contract_end_date");
            double deposit = resultSet.getDouble("contract_deposit");
            double amount = resultSet.getDouble("contract_amount");
            int employeeId = resultSet.getInt("employee_id");
            String customerId = resultSet.getString("customer_id");
            String serviceId = resultSet.getString("service_id");
            return new Contract(id, startDate, endDate, deposit, amount, employeeId, customerId, serviceId);
        }
        return null;
    }

    @Override
    public void insertContract(Contract contract) throws SQLException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = simpleDateFormat.format(contract.getStartDate());
        String endDate = simpleDateFormat.format(contract.getEndDate());
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT);
        preparedStatement.setString(1, contract.getId());
        preparedStatement.setString(2, startDate);
        preparedStatement.setString(3, endDate);
        preparedStatement.setDouble(4, contract.getDeposit());
        preparedStatement.setDouble(5, contract.getAmount());
        preparedStatement.setInt(6, contract.getEmployeeId());
        preparedStatement.setString(7, contract.getCustomerId());
        preparedStatement.setString(8, contract.getServiceId());
        preparedStatement.executeUpdate();
    }

    @Override
    public boolean updateContract(Contract contract) throws SQLException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = simpleDateFormat.format(contract.getStartDate());
        String endDate = simpleDateFormat.format(contract.getEndDate());
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CONTRACT);

        preparedStatement.setString(1, startDate);
        preparedStatement.setString(2, endDate);
        preparedStatement.setDouble(3, contract.getDeposit());
        preparedStatement.setDouble(4, contract.getAmount());
        preparedStatement.setInt(5, contract.getEmployeeId());
        preparedStatement.setString(6, contract.getCustomerId());
        preparedStatement.setString(7, contract.getServiceId());
        preparedStatement.setString(8, contract.getId());
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean deleteContract(int id) {
        return false;
    }
}
