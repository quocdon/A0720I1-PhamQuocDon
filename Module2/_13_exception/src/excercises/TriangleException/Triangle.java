package excercises.TriangleException;

import java.util.IllegalFormatWidthException;
import java.util.Scanner;

public class Triangle {
    public static boolean isTriangle(double a, double b, double c) {
        if (a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a) {
            return true;
        } else return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first edge: ");
        double edge1 = scanner.nextDouble();
        System.out.println("Enter second edge: ");
        double edge2 = scanner.nextDouble();
        System.out.println("Enter third edge: ");
        double edge3 = scanner.nextDouble();
        try {
            if (isTriangle(edge1, edge2, edge3)) {
                System.out.println(edge1 + ", " + edge2+ ", " + edge3 + " are edges of triangle");
            } else throw new IllegalTriangleException(edge1 + ", " + edge2 + ", " + edge3 + " are NOT edges of triangle");
        } catch (IllegalTriangleException e){
            System.out.println(e.getMessage());
        }
    }
}
