package dao.service;

import model.Employee;
import model.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServiceDAO {
    List<Service> selectAll() throws SQLException;
    Service selectServiceById(String id) throws SQLException;
    void insertService(Service service) throws SQLException;
    boolean deleteService(String id) throws SQLException;
    boolean updateService(Service service) throws SQLException;
    List<Service> selectServiceByName(String name) throws SQLException;
}
