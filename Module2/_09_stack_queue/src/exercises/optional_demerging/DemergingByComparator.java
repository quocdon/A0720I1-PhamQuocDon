package exercises.optional_demerging;

import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class DemergingByComparator {
    public static void main(String[] args) {
        LinkedList<Student> studentList = new LinkedList<>();
        Queue<Student> newStudentList = new LinkedList<>();
        Student student1 = new Student("Nam", "male", "01/01/2002");
        Student student2 = new Student("Dat", "male", "01/05/1991");
        Student student3 = new Student("Huong", "female", "03/09/2001");
        Student student4 = new Student("Ngoc", "female", "04/05/1999");
        Student student5 = new Student("Hung", "male", "02/04/1994");
        Student student6 = new Student("Ha", "female", "04/03/2001");
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
        StudentSortByGenderBirthday sortedStudentList = new StudentSortByGenderBirthday();
        Collections.sort(studentList, sortedStudentList);
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}