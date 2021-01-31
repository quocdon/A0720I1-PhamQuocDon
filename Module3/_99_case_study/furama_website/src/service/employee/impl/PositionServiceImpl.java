package service.employee.impl;

import dao.employee.PositionDAO;
import dao.employee.impl.PositionDAOImpl;
import model.Position;
import service.employee.PositionService;

import java.sql.SQLException;
import java.util.List;

public class PositionServiceImpl implements PositionService {
    private PositionDAO positionDAO = new PositionDAOImpl();
    @Override
    public List<Position> findAll() {
        try {
            return positionDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Position getPositionById(int id) {
        try {
            return positionDAO.selectPositionById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
