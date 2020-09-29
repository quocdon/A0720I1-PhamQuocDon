package Practice.QuadraticEquation;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation() {

    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getDiscriminant() {
        return Math.pow(this.getB(), 2) - 4 * this.getA() * this.getC();
    }

    public double getRoot1() {
        if (this.getDiscriminant() < 0)
            return 0;
        return (-this.getB() + Math.pow(this.getDiscriminant(), 0.5)) / (2 * this.getA());
    }

    public double getRoot2() {
        if (this.getDiscriminant() < 0)
            return 0;
        return (-this.getB() - Math.pow(this.getDiscriminant(), 0.5)) / (2 * this.getA());
    }
}
