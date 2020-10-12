package exercises.triangle;

import java.util.Scanner;

public class TestTriangle {
    public static boolean isTriangle(double side1, double side2, double side3) {
        if (side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1) {
            return true;
        } else return false;
    }

    public static void main(String[] args) {
        double side1;
        double side2;
        double side3;
        String color;
        boolean filled;
        String fillInput;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter side 1: ");
            side1 = scanner.nextDouble();
            System.out.print("Enter side 2: ");
            side2 = scanner.nextDouble();
            System.out.print("Enter side 3: ");
            side3 = scanner.nextDouble();
            scanner.skip("\n");
            if (!isTriangle(side1, side2, side3)) {
                System.out.println("Input sides are not sides of triangle");
            }
        } while (!isTriangle(side1, side2, side3));
        Triangle triangle = new Triangle(side1, side2, side3);
        System.out.print("Enter color of triangle: ");
        color = scanner.nextLine();
        triangle.setColor(color);
        do {
            System.out.print("is triangle filled? (only input true/false): ");
            fillInput = scanner.nextLine();
            if (!fillInput.equals("true") && !fillInput.equals("false")) {
                System.out.println("Only input true/false");
            }
        } while (!fillInput.equals("true") && !fillInput.equals("false"));
        filled = Boolean.valueOf(fillInput);
        triangle.setFilled(filled);
        System.out.println(triangle.toString());
        System.out.println("Area of triangle: " + triangle.getArea());
        System.out.println("Perimeter of triangle: " + triangle.getPerimeter());
    }
}
