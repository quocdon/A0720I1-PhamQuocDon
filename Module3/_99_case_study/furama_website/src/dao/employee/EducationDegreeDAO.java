package dao.employee;

import model.EducationDegree;
import model.Position;

import java.sql.SQLException;
import java.util.List;

public interface EducationDegreeDAO {
    List<EducationDegree> selectAll() throws SQLException;
    EducationDegree selectEducationDegreeById(int id) throws SQLException;
}
