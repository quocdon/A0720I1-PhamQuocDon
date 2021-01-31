package service.service.impl;

import dao.service.RentTypeDAO;
import dao.service.impl.RentTypeDAOImpl;
import model.RentType;
import service.service.RentTypeService;

import java.sql.SQLException;
import java.util.List;

public class RentTypeServiceImpl implements RentTypeService {
    RentTypeDAO rentTypeDAO = new RentTypeDAOImpl();
    @Override
    public List<RentType> findAll() {
        try {
            return rentTypeDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public RentType getRentTypeById(int id) {
        try {
            return rentTypeDAO.selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
