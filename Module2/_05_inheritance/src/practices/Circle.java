package practices;

public class Circle extends Shape {
    private double radius;

    public Circle() {
        this.radius = 1;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "A circle with radius = " + radius + " which is a subclass of " + super.toString();
    }
}
