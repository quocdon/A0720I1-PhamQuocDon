package service.customer.impl;

import dao.customer.CustomerTypeDAO;
import dao.customer.impl.CustomerTypeDAOImpl;
import model.CustomerType;
import service.customer.CustomerTypeService;

import java.sql.SQLException;
import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService {
    CustomerTypeDAO customerTypeDAO = new CustomerTypeDAOImpl();
    @Override
    public List<CustomerType> findAll() {
        try {
            return customerTypeDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CustomerType getCustomerTypeById(int id) {
        try {
            return customerTypeDAO.selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
