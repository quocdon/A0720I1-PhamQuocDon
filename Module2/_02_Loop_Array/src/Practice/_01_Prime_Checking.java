package Practice;

import java.util.Scanner;

public class _01_Prime_Checking {
    public static void main(String[] args) {
        System.out.print("Enter number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number < 2)
            System.out.println(number + " is not prime");
        else{
            int i = 2;
            boolean check = true;
            while (i <= Math.sqrt(number)) {
                if (number % i == 0){
                    check = false;
                    break;
                }
                i++;
            }
            if (check == true)
                System.out.println(number + " is prime");
            else
                System.out.println(number + " is not prime");
        }
    }
}
