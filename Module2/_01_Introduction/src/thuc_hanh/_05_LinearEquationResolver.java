package Thuc_Hanh;
import java.util.Scanner;

public class _05_LinearEquationResolver {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'ax + b = 0', please enter constants");
        Scanner scanner = new Scanner(System.in);
        System.out.println("a: ");
        double a = scanner.nextDouble();
        System.out.println("b: ");
        double b = scanner.nextDouble();
        if (a == 0){
            if (b == 0){
                System.out.println("Solution is all x");
            } else {
                System.out.println("No solution");
            }
        } else {
            double solution = -b/a;
            System.out.println("Equation pass with x = " + solution);
        }
    }
}
