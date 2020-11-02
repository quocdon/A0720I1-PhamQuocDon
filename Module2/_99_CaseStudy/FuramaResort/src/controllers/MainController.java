package controllers;

import java.util.Scanner;

public class MainController {
    public static void displayMainMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("MAIN MENU: \n" +
                "1. Add new services\n" +
                "2. Show services\n" +
                "3. Add new customer\n" +
                "4. Show information of customer\n" +
                "5. Add new booking\n" +
                "6. Show information of Employee\n" +
                "7. Exit\n" +
                "Please choose the function: ");
        int mainMenuIndex = scanner.nextInt();
    }

    public static void addNewServices(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("SERVICES: \n" +
                "1. Add new villa\n" +
                "2. Add new house\n" +
                "3. Add new room\n" +
                "4. Back to menu\n" +
                "5. Exit\n" +
                "Please choose the function: ");
        int newServicesIndex = scanner.nextInt();
    }
}
