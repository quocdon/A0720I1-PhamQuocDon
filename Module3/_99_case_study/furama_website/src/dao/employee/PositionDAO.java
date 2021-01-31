package dao.employee;

import model.Position;

import java.sql.SQLException;
import java.util.List;

public interface PositionDAO {
    List<Position> selectAll() throws SQLException;
    Position selectPositionById(int id) throws SQLException;
}
