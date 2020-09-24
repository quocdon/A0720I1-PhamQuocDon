package Practice;

import java.sql.SQLOutput;
import java.util.Scanner;

public class _02_Bank_Interest {
    public static void main(String[] args) {
        double total_interest = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter deposit amount: ");
        double deposit = scanner.nextDouble();
        System.out.print("Enter number of month: ");
        int month = scanner.nextInt();
        System.out.print("Enter interest rate by percentage: ");
        double interest = scanner.nextDouble();
        for (int i = 0; i < month; i++)
            total_interest += deposit*(interest/100/12);
        System.out.print("Total interest: " + total_interest);
    }


}
