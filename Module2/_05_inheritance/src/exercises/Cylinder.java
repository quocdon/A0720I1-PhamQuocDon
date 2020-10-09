package exercises;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "radius=" + getRadius() +
                ", color='" + getColor() + '\'' +
                ", height=" + height +
                '}';
    }

    public double volume() {
        return Math.PI * Math.pow(getRadius(), 2) * height;
    }
}
