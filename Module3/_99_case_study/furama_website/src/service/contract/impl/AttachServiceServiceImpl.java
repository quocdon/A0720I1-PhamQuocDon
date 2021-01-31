package service.contract.impl;

import dao.contract.AttachServiceDAO;
import dao.contract.impl.AttachServiceDAOImpl;
import model.AttachService;
import service.contract.AttachServiceService;

import java.sql.SQLException;
import java.util.List;

public class AttachServiceServiceImpl implements AttachServiceService {
    AttachServiceDAO attachServiceDAO = new AttachServiceDAOImpl();
    @Override
    public List<AttachService> findAll() {
        try {
            return attachServiceDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AttachService getRentTypeById(int id) {
        try {
            return attachServiceDAO.selectAttachServiceById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
