package dao;

import models.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    List<Customer> getAll() throws SQLException;
    Customer getCustomer(String userName) throws SQLException;
    void updateCustomer(Customer customer) throws SQLException;
}
