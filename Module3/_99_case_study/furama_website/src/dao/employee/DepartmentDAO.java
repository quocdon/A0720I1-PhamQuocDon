package dao.employee;

import model.Department;
import model.EducationDegree;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO {
    List<Department> selectAll() throws SQLException;
    Department selectDepartmentById(int id) throws SQLException;
}
