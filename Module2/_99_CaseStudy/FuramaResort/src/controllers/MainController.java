package controllers;

import static Views.Main.scanner;
import static controllers.BookingController.addNewBooking;
import static controllers.CinemaTicketController.cinemaTicket;
import static controllers.CustomerController.addNewCustomer;
import static controllers.CustomerController.showCustomerList;
import static controllers.EmployeeController.searchEmployee;
import static controllers.EmployeeController.showEmployee;
import static controllers.ServiceController.addNewServices;
import static controllers.ServiceController.showServices;

public class MainController {

    public static void displayMainMenu() {
        System.out.print("---------------\nMAIN MENU: \n" +
                "1. Add new services\n" +
                "2. Show services\n" +
                "3. Add new customer\n" +
                "4. Show information of customers\n" +
                "5. Add new booking\n" +
                "6. Cinema ticket\n" +
                "7. Show information of Employee\n" +
                "8. Search employee profile\n" +
                "9. Exit\n" +
                "Please choose the function: ");
        String mainMenuIndex = scanner.nextLine();
        switch (mainMenuIndex) {
            case "1":
                addNewServices();
                break;
            case "2": {
                showServices();
                break;
            }
            case "3":
                addNewCustomer();
                break;
            case "4": {
                showCustomerList();
                break;
            }
            case "5": {
                addNewBooking();
                break;
            }
            case "6": {
                cinemaTicket();
                break;
            }
            case "7": {
                showEmployee();
                break;
            }
            case "8": {
                searchEmployee();
                break;
            }
            case "9":
                System.exit(0);
            default:
                System.out.println("The index input is invalid. Please press ENTER to continue !!!");
                scanner.nextLine();
                displayMainMenu();
        }
    }
}
