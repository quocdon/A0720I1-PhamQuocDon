package exercises.array_list;

public class TestMyList {
    public static class Student{
        int id;
        String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        Student student_1 = new Student(1,"Nam");
        Student student_2 = new Student(2,"Cuong");
        Student student_3 = new Student(3,"Thinh");
        MyArrayList<Student> studentList = new MyArrayList<Student>();
        studentList.add(student_1);
        studentList.add(student_3);
        studentList.add(student_2,1);

        Student student;
        student = studentList.get(2);
        System.out.println(student);
        studentList.remove(0);
        for (int i = 0; i < studentList.size(); i++){
            System.out.print(studentList.elements[i]);
        }

    }
}
