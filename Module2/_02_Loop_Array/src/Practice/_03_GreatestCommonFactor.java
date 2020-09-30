package Practice;

import java.util.Scanner;

public class _03_GreatestCommonFactor {
    public static int gcf(int num1, int num2){
        while (num1 != num2){
            if (num1 > num2)
                num1 = num1 - num2;
            else num2 = num2 - num1;

        }
        return num1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int number1 = scanner.nextInt();
        System.out.print("Enter number 2: ");
        int number2 = scanner.nextInt();
        number1 = Math.abs(number1);
        number2 = Math.abs(number2);
        int gcf = gcf(number1, number2);
        System.out.print("Greatest common factor of " + number1 + " and " + number2 + " is: " + gcf);
    }
}
