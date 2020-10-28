package exercises.optional_demerging;

import java.util.Comparator;

public class StudentSortByGenderBirthday implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        int result = student1.getGender().compareTo(student2.getGender());
        if (result == 0){
            return student1.getBirthday().compareTo(student2.getBirthday());
        } else return result;
    }
}
