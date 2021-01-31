package dao.service;

import model.RentType;

import java.sql.SQLException;
import java.util.List;

public interface ServiceTypeDAO {
    List<model.ServiceType> selectAll() throws SQLException;
    model.ServiceType selectById(int id) throws SQLException;
}
