package exercises.resizeable;

import practices.Shape;

public class Circle extends Shape implements Resizeable {
    private double radius;

    public Circle() {
        this.radius = 1;
    }

    public Circle(double radius) {
        this.radius = radius;
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

    public double getArea(){
        return Math.pow(radius, 2)*Math.PI;
    }

    @Override
    public String toString() {
        return "A circle with radius = " + radius + " which is a subclass of " + super.toString();
    }

    @Override
    public void resize(double percent) {
        this.radius *= 1 + percent / 100;
    }
}
