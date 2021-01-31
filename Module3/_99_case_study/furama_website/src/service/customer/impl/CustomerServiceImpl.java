package service.customer.impl;

import dao.customer.CustomerDAO;
import dao.customer.impl.CustomerDAOImpl;
import model.Contract;
import model.Customer;
import service.IdComparator;
import service.customer.CustomerService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerDAO customerDAO = new CustomerDAOImpl();
    @Override
    public List<Customer> findAll() {
        try {
            return customerDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer getById(String id) {
        try {
            return customerDAO.selectCustomerById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Customer customer) {
        try {
            customerDAO.insertCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean remove(String id) {
        try {
            customerDAO.deleteCustomer(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        try {
            customerDAO.updateCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Customer> searchByName(String name) {
        try {
            return customerDAO.selectCustomerByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String generateId() {
        List<String> idList = new ArrayList<>();
        List<Customer> customerList = new ArrayList<>();
        try {
            customerList = customerDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (customerList.size() == 0){
            return "KH-0001";
        }

        for (Customer customer : customerList){
            idList.add(customer.getId());
        }

        IdComparator idComparator = new IdComparator();
        Collections.sort(idList, idComparator);
        String lastId = idList.get(idList.size()-1);
        String newId = "KH-".concat(String.format("%04d", Integer.parseInt(lastId.substring(3)) + 1));
        return newId;
    }
}
