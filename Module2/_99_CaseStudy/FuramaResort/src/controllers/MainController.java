package controllers;

import models.Customer;
import models.Employee;
import models.ProfileCarbinet;
import models.Services;

import java.util.*;

import static controllers.BookingController.addNewBooking;
import static controllers.CinemaTicketController.cinemaTicket;
import static controllers.CustomerController.addNewCustomer;
import static controllers.CustomerController.showCustomerList;
import static controllers.EmployeeController.searchEmployee;
import static controllers.EmployeeController.showEmployee;
import static controllers.ServiceController.addNewServices;
import static controllers.ServiceController.showServices;

public class MainController {
    public static Scanner scanner = new Scanner(System.in);
    public static final String VILLA_FILE_PATH = "src/data/Villa.csv";
    public static final String HOUSE_FILE_PATH = "src/data/House.csv";
    public static final String ROOM_FILE_PATH = "src/data/Room.csv";
    public static final String CUSTOMER_FILE_PATH = "src/data/Customer.csv";
    public static final String BOOKING_FILE_PATH = "src/data/Booking.csv";
    public static final String EMPLOYEE_FILE_PATH = "src/data/Employee.csv";
    public static final String VILLA_CODE = "SVVL";
    public static final String HOUSE_CODE = "SVHO";
    public static final String ROOM_CODE = "SVRO";
    public static List<Services> villaList = new ArrayList<>();
    public static List<Services> houseList = new ArrayList<>();
    public static List<Services> roomList = new ArrayList<>();
    public static List<Customer> customerList = new ArrayList<>();
    public static LinkedHashMap<String, Employee> employeeHashMap = new LinkedHashMap<>();
    public static List<Customer> bookingList = new ArrayList<>();
    public static Queue<Customer> waitingList = new LinkedList<>();
    public static Queue<Customer> boughtTicketList = new LinkedList<>();
    public static ProfileCarbinet profileCarbinet = new ProfileCarbinet();
    public static int numTicket = 0;

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
