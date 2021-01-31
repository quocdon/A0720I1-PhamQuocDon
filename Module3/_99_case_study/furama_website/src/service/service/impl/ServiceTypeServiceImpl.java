package service.service.impl;

import dao.service.ServiceTypeDAO;
import dao.service.impl.ServiceTypeDAOImpl;
import model.ServiceType;
import service.service.ServiceTypeService;

import java.sql.SQLException;
import java.util.List;

public class ServiceTypeServiceImpl implements ServiceTypeService {
    ServiceTypeDAO serviceTypeDAO = new ServiceTypeDAOImpl();

    @Override
    public List<ServiceType> findAll() {
        try {
            return serviceTypeDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ServiceType getServiceTypeById(int id) {
        try {
            return serviceTypeDAO.selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
