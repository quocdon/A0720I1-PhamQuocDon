package controllers;

import java.io.IOException;
import java.util.Scanner;

public class MainController {
    public static void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("---------------\nMAIN MENU: \n" +
                "1. Add new services\n" +
                "2. Show services\n" +
                "3. Add new customer\n" +
                "4. Show information of customer\n" +
                "5. Add new booking\n" +
                "6. Show information of Employee\n" +
                "7. Exit\n" +
                "Please choose the function: ");
        String mainMenuIndex = scanner.nextLine();
        switch (mainMenuIndex) {
            case "1":
                addNewServices();
                break;
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
                System.exit(0);
            default:
                System.out.println("The index input is invalid. Please press ENTER to continue !!!");
                scanner.nextLine();
                displayMainMenu();
        }
    }
    public static void addNewServices() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("---------------\nSERVICES: \n" +
                "1. Add new villa\n" +
                "2. Add new house\n" +
                "3. Add new room\n" +
                "4. Back to menu\n" +
                "5. Exit\n" +
                "Please choose the function: ");
        String newServicesIndex = scanner.nextLine();
        switch (newServicesIndex) {
            case "1": {
                WriteData.villa();
                break;
            }
            case "2":
                WriteData.house();
                break;
            case "3":
                WriteData.room();
                break;
            case "4":
                displayMainMenu();
                break;
            case "5":
                System.exit(0);
            default:
                System.out.println("The index input is invalid. Please press ENTER to continue !!!");
                scanner.nextLine();
                addNewServices();
        }
        addNewServices();
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
