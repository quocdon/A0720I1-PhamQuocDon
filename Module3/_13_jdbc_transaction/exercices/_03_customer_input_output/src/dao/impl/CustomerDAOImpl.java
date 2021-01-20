package dao.impl;

import dao.CustomerDAO;
import models.Customer;
import utils.DBConnection;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    private static final String SELECT_ALL_CUSTOMERS = "select * from customers";
    @Override
    public List<Customer> getAll() throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String userName = resultSet.getString("username");
            String name = resultSet.getString("name");
            String birthday = resultSet.getString("birthday");
            String address = resultSet.getString("address");
            String image = resultSet.getString("image");
            customerList.add(new Customer(userName, name, birthday, address, image));
        }
        return null;
    }

    @Override
    public Customer getCustomer(String userName) throws SQLException {
        List<Customer> customerList = this.getAll();
        for (Customer customer: customerList){
            if (customer.getUsername().equals(userName)){
                return customer;
            }
        }
        return null;
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {

    }
}
