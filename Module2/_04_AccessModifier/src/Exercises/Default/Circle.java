package Exercises.Default;

public class Circle {
     private double radius = 1.0;
    private String color = "Red";

    public Circle() {
    }
    public Circle(double radius){
        this.radius = radius;
        this.color = "Red";
    }

    protected double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }
}
