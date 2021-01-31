package dao.customer;

import model.CustomerType;

import java.sql.SQLException;
import java.util.List;

public interface CustomerTypeDAO {
    List<CustomerType> selectAll() throws SQLException;
    CustomerType selectById(int id) throws SQLException;
}
