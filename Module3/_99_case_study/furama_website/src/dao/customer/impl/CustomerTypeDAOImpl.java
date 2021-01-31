package dao.customer.impl;

import dao.customer.CustomerTypeDAO;
import model.CustomerType;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeDAOImpl implements CustomerTypeDAO {
    private static final String SELECT_ALL = "Select * from customer_type";
    @Override
    public List<CustomerType> selectAll() throws SQLException {
        List<CustomerType> customerTypeList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("customer_type_id");
            String name = resultSet.getNString("customer_type_name");
            customerTypeList.add(new CustomerType(id, name));
        }
        return customerTypeList;
    }

    @Override
    public CustomerType selectById(int id) throws SQLException {
        List<CustomerType> customerTypeList = this.selectAll();
        for (CustomerType customerType : customerTypeList){
            if (customerType.getId() == id){
                return customerType;
            }
        }
        return null;
    }
}
