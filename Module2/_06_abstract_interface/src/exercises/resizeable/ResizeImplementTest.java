package exercises.resizeable;

import practices.Shape;

public class ResizeImplementTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(10);
        shapes[1] = new Rectangle(10, 20);
        shapes[2] = new Square(10);
        double resizePercent = Math.random() * 100;
        //double resizePercent = 10;
        System.out.println("Resize percent: " + resizePercent + "% \n----------");
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                System.out.println("Area of circle before resize: " + ((Circle) shape).getArea());
                ((Circle) shape).resize(resizePercent);
                System.out.println("Area of circle after resize: " + ((Circle) shape).getArea() + "\n----------");
            } else if (shape instanceof Square) {
                System.out.println("Area of square before resize: " + ((Square) shape).getArea());
                ((Square) shape).resize(resizePercent);
                System.out.println("Area of square after resize: " + ((Square) shape).getArea() + "\n----------");
            } else if (shape instanceof Rectangle){
                System.out.println("Area of rectangle before resize: " + ((Rectangle) shape).getArea());
                ((Rectangle) shape).resize(resizePercent);
                System.out.println("Area of rectangle after resize: " + ((Rectangle) shape).getArea() + "\n----------");
            }
        }
    }
}
