package dao.customer.impl;

import dao.customer.CustomerDAO;
import model.Customer;
import model.Employee;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    private static final String SELECT_ALL = "Select * from customer";
    private static final String SELECT_BY_ID = "Select * from customer where customer_id = ?";
    private static final String INSERT_CUSTOMER = "insert into customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_idcard, customer_phone, customer_email, customer_address) values (?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_CUSTOMER = "delete from customer where customer_id = ?";
    private static final String UPDATE_CUSTOMER = "update customer set customer_type_id=?, customer_name=?, customer_birthday=?, customer_gender=?, customer_idCard=?, customer_phone=?, customer_email=?, customer_address=?  where customer_id = ?";
    @Override
    public List<Customer> selectAll() throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String id = resultSet.getString("customer_id");
            int customerTypeId = resultSet.getInt("customer_type_id");
            String name = resultSet.getNString("customer_name");
            Date birthday = resultSet.getDate("customer_birthday");
            String gender = resultSet.getNString("customer_gender");
            String idCard = resultSet.getString("customer_idCard");
            String phone = resultSet.getString("customer_phone");
            String email = resultSet.getString("customer_email");
            String address = resultSet.getString("customer_address");
            customerList.add(new Customer(id, customerTypeId, name, birthday, gender, idCard, phone, email, address));
        }
        return customerList;
    }

    @Override
    public Customer selectCustomerById(String id) throws SQLException {
        List<Customer> customerList = this.selectAll();
        for (Customer customer: customerList){
            if (customer.getId().equals(id)){
                return customer;
            }
        }
        return null;
    }

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = simpleDateFormat.format(customer.getBirthday());
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
        preparedStatement.setString(1, customer.getId());
        preparedStatement.setInt(2, customer.getCustomerTypeId());
        preparedStatement.setNString(3, customer.getName());
        preparedStatement.setString(4, birthday);
        preparedStatement.setNString(5, customer.getGender());
        preparedStatement.setString(6, customer.getIdCard());
        preparedStatement.setString(7, customer.getPhone());
        preparedStatement.setString(8, customer.getEmail());
        preparedStatement.setString(9, customer.getAddress());
        preparedStatement.executeUpdate();
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
        preparedStatement.setString(1, id);
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = simpleDateFormat.format(customer.getBirthday());
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
        preparedStatement.setInt(1, customer.getCustomerTypeId());
        preparedStatement.setNString(2, customer.getName());
        preparedStatement.setString(3, birthday);
        preparedStatement.setNString(4, customer.getGender());
        preparedStatement.setString(5, customer.getIdCard());
        preparedStatement.setString(6, customer.getPhone());
        preparedStatement.setString(7, customer.getEmail());
        preparedStatement.setString(8, customer.getAddress());
        preparedStatement.setString(9, customer.getId());
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public List<Customer> selectCustomerByName(String name) throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer : customerList){
            if (customer.getName().contains(name)){
                customerList.add(customer);
            }
        }
        return customerList;
    }
}
