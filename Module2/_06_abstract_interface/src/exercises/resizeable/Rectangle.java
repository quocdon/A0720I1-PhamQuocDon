package exercises.resizeable;

public class Rectangle extends practices.Shape implements Resizeable {
    private double width;
    private double length;

    public Rectangle() {
        this.width = 1;
        this.length = 1;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return this.width * this.length;
    }

    public double getPerimeter() {
        return 2 * (this.length + this.width);
    }

    @Override
    public String toString() {
        return "A rectangle with width = " + width + " and length = " + length + ", which is a subclass of " + super.toString();
    }

    @Override
    public void resize(double percent) {
        this.width *= 1 + percent / 100;
        this.length *= 1 + percent / 100;
    }
}
