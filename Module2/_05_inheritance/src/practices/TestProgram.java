package practices;

public class TestProgram {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(5);
        System.out.println(circle.toString());

        Rectangle rectangle = new Rectangle();
        rectangle.setColor("red");
        rectangle.setWidth(6);
        rectangle.setFilled(false);
        System.out.println(rectangle.toString());

        Square square = new Square();
        square.setLength(5);
        square.setColor("yellow");
        System.out.println(square.toString());
    }
}
