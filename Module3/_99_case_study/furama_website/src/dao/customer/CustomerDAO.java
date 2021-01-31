package dao.customer;

import model.Customer;
import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    List<Customer> selectAll() throws SQLException;
    Customer selectCustomerById(String id) throws SQLException;
    void insertCustomer(Customer customer) throws SQLException;
    boolean deleteCustomer(String id) throws SQLException;
    boolean updateCustomer(Customer customer) throws SQLException;
    List<Customer> selectCustomerByName(String name) throws SQLException;
}
