package Bai_Tap;

import java.util.Scanner;

public class _01_Greeting {
    public static void main(String[] args) {
        System.out.print("Please enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.print("Hello " + name);
    }
}
