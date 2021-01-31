package dao.service;

import model.RentType;

import java.sql.SQLException;
import java.util.List;

public interface RentTypeDAO {
    List<RentType> selectAll() throws SQLException;
    RentType selectById(int id) throws SQLException;
}
