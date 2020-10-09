package exercises;

public class TestProgram {
    public static void main(String[] args) {
        Circle circle = new Circle(5,"red");
        Cylinder cylinder = new Cylinder(4, "blue", 3);
        System.out.println(circle.toString());
        System.out.println(cylinder.toString());
    }

}
