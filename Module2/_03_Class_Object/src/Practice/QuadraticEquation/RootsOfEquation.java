package Practice.QuadraticEquation;

import java.util.Scanner;

public class RootsOfEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();
        QuadraticEquation equation = new QuadraticEquation(a,b,c);
        if (equation.getDiscriminant() > 0){
            System.out.println("Equation has 2 roots:");
            System.out.println("R1 = " + equation.getRoot1());
            System.out.println("R2 = " + equation.getRoot2());
        } else if (equation.getDiscriminant() == 0){
            System.out.println("Equation has 1 root:");
            System.out.println("R = " + equation.getRoot1());
        } else System.out.println("Equation has no root");

    }
}
