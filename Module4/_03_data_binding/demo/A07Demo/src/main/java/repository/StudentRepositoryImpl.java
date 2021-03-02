package repository;

import models.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepositoryImpl implements StudentRepository {
    static Map<Integer, Student> listStudent;
    static {
        listStudent = new HashMap<>();
        listStudent.put(1, new Student(1, "Nam", "Java"));
        listStudent.put(2, new Student(2, "Viet", "C#"));
        listStudent.put(3, new Student(3, "Phat", "PHP"));
        listStudent.put(4, new Student(4, "Dat", "Python"));
    }

    @Override
    public List<Student> getAllStudent() {
        return new ArrayList<>(listStudent.values());
    }

    @Override
    public void saveStudent(Student student) {
        listStudent.put(student.getId(), student);
    }
}
