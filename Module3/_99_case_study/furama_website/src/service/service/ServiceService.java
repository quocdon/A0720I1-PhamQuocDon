package service.service;

import model.Employee;
import model.Service;

import java.util.List;

public interface ServiceService {
    List<Service> findAll();
    Service getById(String id);
    void save(Service service);
    boolean remove(String id);
    boolean update(Service service);
    List<Service> searchByName(String name);
    String generateId();
}
