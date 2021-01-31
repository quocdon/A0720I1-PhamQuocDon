package service.customer;

import model.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAll();
    CustomerType getCustomerTypeById(int id);
}
