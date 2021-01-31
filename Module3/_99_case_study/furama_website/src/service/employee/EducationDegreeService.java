package service.employee;

import model.EducationDegree;
import model.Position;

import java.util.List;

public interface EducationDegreeService {
    List<EducationDegree> findAll();
    EducationDegree getEducationDegreeById(int id);
}
