package exercises.linked_list;

public class TestMyLinkedList {
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
        Student student_1 = new Student(1, "An");
        Student student_2 = new Student(2, "Binh");
        Student student_3 = new Student(3, "Cuong");
        Student student_4 = new Student(4, "Dung");
        MyLinkedList<Student> myLinkedListStudent = new MyLinkedList<Student>();
        myLinkedListStudent.addFirst(student_2);
        myLinkedListStudent.addFirst(student_1);
        myLinkedListStudent.addLast(student_3);
        myLinkedListStudent.add(3, student_4);
        myLinkedListStudent.remove(1);
        MyLinkedList<Student> newStudent = myLinkedListStudent.clone();

        for (int i = 0; i < myLinkedListStudent.size(); i++) {
            Student student = (Student) myLinkedListStudent.get(i);
            System.out.println(student.getName());
        }
        for (int i = 0; i < newStudent.size(); i++) {
            Student student = (Student) newStudent.get(i);
            System.out.println(student.getName());
        }
        //System.out.println("Deleted Student: " + deletedStudent);
        //System.out.println(myLinkedListStudent.contains(student_2));
        /*Student student = myLinkedListStudent.getFirst();
        System.out.println(student.getName());
        Student lastStudent = myLinkedListStudent.getLast();
        System.out.println(lastStudent.getName());
        Student findStudent = new Student(2,"Binh");
        System.out.println(myLinkedListStudent.indexOf(student_1));
*/
    }
}
