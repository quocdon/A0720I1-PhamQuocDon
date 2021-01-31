package service.employee.impl;

import dao.employee.EducationDegreeDAO;
import dao.employee.impl.EducationDegreeDAOImpl;
import model.EducationDegree;
import service.employee.EducationDegreeService;

import java.sql.SQLException;
import java.util.List;

public class EducationDegreeServiceImpl implements EducationDegreeService {
    private EducationDegreeDAO educationDegreeDAO = new EducationDegreeDAOImpl();
    @Override
    public List<EducationDegree> findAll() {
        try {
            return educationDegreeDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public EducationDegree getEducationDegreeById(int id) {
        try {
            return educationDegreeDAO.selectEducationDegreeById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
