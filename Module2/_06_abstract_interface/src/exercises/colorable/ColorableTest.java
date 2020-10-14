package exercises.colorable;

import exercises.resizeable.Circle;
import exercises.resizeable.Rectangle;
import exercises.resizeable.Square;
import practices.Shape;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(10);
        shapes[1] = new Rectangle(10, 20);
        shapes[2] = new Square(10);
        for (Shape shape : shapes){
            if (shape instanceof Colorable){
                ((Colorable) shape).howToColor();
            }
        }
    }
}
