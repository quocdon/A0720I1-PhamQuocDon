package service.customer;

import model.Customer;
import model.Employee;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer getById(String id);
    void save(Customer customer);
    boolean remove(String id);
    boolean update(Customer customer);
    List<Customer> searchByName(String name);
    String generateId();
}
