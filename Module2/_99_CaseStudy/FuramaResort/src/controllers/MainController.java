package controllers;

import commons.UserException;
import models.*;

import java.util.*;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);
    public static final String VILLA_FILE_PATH = "src/data/Villa.csv";
    public static final String HOUSE_FILE_PATH = "src/data/House.csv";
    public static final String ROOM_FILE_PATH = "src/data/Room.csv";
    public static final String CUSTOMER_FILE_PATH = "src/data/Customer.csv";
    public static final String BOOKING_FILE_PATH = "src/data/Booking.csv";
    public static final String EMPLOYEE_FILE_PATH = "src/data/Employee.csv";
    public static final String VILLA_CODE = "SVVL";
    public static final String HOUSE_CODE = "SVHO";
    public static final String ROOM_CODE = "SVRO";
    public static List<Services> villaList = FileCsv.readServiceListFromCSV(VILLA_FILE_PATH);
    public static List<Services> houseList = FileCsv.readServiceListFromCSV(HOUSE_FILE_PATH);
    public static List<Services> roomList = FileCsv.readServiceListFromCSV(ROOM_FILE_PATH);
    public static List<Customer> customerList = FileCsv.readCustomerListFromCSV(CUSTOMER_FILE_PATH);
    public static LinkedHashMap<String, Employee> employeeHashMap = FileCsv.readEmployeeFromCSV(EMPLOYEE_FILE_PATH);
    public static List<Booking> bookingList = new ArrayList<>();
    public static Queue<Customer> waitingList = new LinkedList<>();
    public static Queue<Customer> boughtTicketList = new LinkedList<>();
    public static ProfileCarbinet profileCarbinet = new ProfileCarbinet();
    public static int numTicket = 0;

    public static void displayMainMenu() throws UserException {
        System.out.print("---------------\nMAIN MENU: \n" +
                "1. Add new services\n" +
                "2. Show services\n" +
                "3. Add new customer\n" +
                "4. Show information of customers\n" +
                "5. Add new booking\n" +
                "6. Show all bookings\n" +
                "7. Cinema ticket\n" +
                "8. Show information of Employee\n" +
                "9. Search employee profile\n" +
                "10. Exit\n" +
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
            case "4":
                System.out.println("-----------------");
                System.out.println("LIST OF CUSTOMERS");
                for (Customer customer : customerList) {
                    System.out.println(customer.showInfo());
                }
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                displayMainMenu();
            case "5": {
                addNewBooking();
                break;
            }
            case "6": {
                System.out.println("---------------");
                System.out.println("LIST OF BOOKINGS: ");
                for (Booking booking : bookingList) {
                    System.out.println(booking.showInfo());
                }
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                displayMainMenu();
                break;
            }
            case "7": {
                cinemaTicket();
                break;
            }
            case "8": {
                System.out.println("--------------------");
                System.out.println("LIST OF EMPLOYEE");
                for (String key : employeeHashMap.keySet()) {
                    System.out.println(key + " - " + employeeHashMap.get(key));
                }
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                displayMainMenu();
                break;
            }
            case "9": {
                for (String key: employeeHashMap.keySet()){
                    profileCarbinet.add(employeeHashMap.get(key));
                }
                System.out.print("Input employee name: ");
                String name = scanner.nextLine();
                Employee employee = profileCarbinet.search(name);
                if (employee == null){
                    System.out.println("Employee profile not found");
                } else {
                    System.out.println(employee.toString());
                }
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                displayMainMenu();
                break;
            }
            case "10":
                System.exit(0);
            default:
                System.out.println("The index input is invalid. Please press ENTER to continue !!!");
                scanner.nextLine();
                displayMainMenu();
        }
    }

    public static void addNewServices() throws UserException {
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
                Villa villa = InputData.villa();
                villaList.add(villa);
                FileCsv.writeServicesToCSV(villaList, VILLA_FILE_PATH);
                System.out.println("Add " + villa.showInfo() + " successfully");
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                addNewServices();
                break;
            }
            case "2": {
                House house = InputData.house();
                houseList.add(house);
                FileCsv.writeServicesToCSV(houseList, HOUSE_FILE_PATH);
                System.out.println("Add " + house.showInfo() + " successfully");
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                addNewServices();
                break;
            }
            case "3": {
                Room room = InputData.room();
                roomList.add(room);
                FileCsv.writeServicesToCSV(roomList, ROOM_FILE_PATH);
                System.out.println("Add " + room.showInfo() + " successfully");
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                addNewServices();
                break;
            }
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

    public static void showServices() throws UserException {
        System.out.println("---------------");
        System.out.print("SHOW ALL SERVICES\n" +
                "1. Show all Villa\n" +
                "2. Show all House\n" +
                "3. Show all Room\n" +
                "4. Show all name of villa not duplicate\n" +
                "5. Show all name of house not duplicate\n" +
                "6. Show all name of room not duplicate\n" +
                "7. Back to menu\n" +
                "8. Exit\n" +
                "Please choose the function: ");
        String showServicesIndex = scanner.nextLine();
        switch (showServicesIndex) {
            case "1": {
                for (Services services : villaList) {
                    System.out.println(services.showInfo());
                }
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                showServices();
                break;
            }
            case "2": {
                for (Services services : houseList) {
                    System.out.println(services.showInfo());
                }
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                showServices();
                break;
            }
            case "3": {
                for (Services services : roomList) {
                    System.out.println(services.showInfo());
                }
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                showServices();
                break;
            }
            case "4": {
                showServiceNameNotDupicate(villaList);
                showServices();
                break;
            }
            case "5": {
                showServiceNameNotDupicate(houseList);
                showServices();
                break;
            }
            case "6": {
                showServiceNameNotDupicate(roomList);
                showServices();
                break;
            }
            case "7": {
                displayMainMenu();
                break;
            }
            case "8": {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("The index input is invalid. Please press ENTER to continue !!!");
                scanner.nextLine();
                showServices();
            }
        }
    }

    public static void addNewCustomer() throws UserException {
        Customer customer = InputData.customer();
        customerList.add(customer);
        FileCsv.writeCustomerToCSV(customerList, CUSTOMER_FILE_PATH);
        System.out.println("Add " + customer.showInfo() + " successfully");
        System.out.println("Press ENTER to continue");
        scanner.nextLine();
        displayMainMenu();
    }

    public static void showServiceNameNotDupicate(List<Services> serviceList) {
        HashSet<String> serviceNameList = new HashSet<>();
        for (Services service : serviceList) {
            serviceNameList.add(service.getServiceName());
        }
        System.out.println(serviceNameList.toString());
        System.out.println("Press ENTER to continue");
        scanner.nextLine();
    }

    public static void addNewBooking() throws UserException {
        System.out.println("--------------");
        System.out.println("ADD NEW BOOKING");
        System.out.println("LIST OF CUSTOMERS");
        Customer customer = InputData.selectElementInList(customerList);
        System.out.print("LIST OF SERVICES: \n" +
                "1. Booking Villa\n" +
                "2. Booking House\n" +
                "3. Booking Room\n" +
                "Please choose function: ");
        String bookingIndex = scanner.nextLine();
        switch (bookingIndex) {
            case "1": {
                Services service = InputData.selectElementInList(villaList);
                Booking booking = new Booking(customer, service);
                bookingList.add(booking);
                FileCsv.writeBookingToCSV(bookingList, BOOKING_FILE_PATH);
                System.out.println("Add " + booking.showInfo() + " successfully");
                break;
            }
            case "2": {
                Services service = InputData.selectElementInList(houseList);
                Booking booking = new Booking(customer, service);
                bookingList.add(booking);
                FileCsv.writeBookingToCSV(bookingList, BOOKING_FILE_PATH);
                System.out.println("Add " + booking.showInfo() + " successfully");
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                displayMainMenu();
                break;
            }
            case "3": {
                Services service = InputData.selectElementInList(roomList);
                Booking booking = new Booking(customer, service);
                bookingList.add(booking);
                FileCsv.writeBookingToCSV(bookingList, BOOKING_FILE_PATH);
                System.out.println("Add " + booking.showInfo() + " successfully");
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                displayMainMenu();
                break;
            }
            default: {
                System.out.println("The index input is invalid. Please press ENTER to continue !!!");
                scanner.nextLine();
                displayMainMenu();
            }
        }
    }

    public static void cinemaTicket() throws UserException {
        System.out.println("------------------");
        System.out.println("CINEMA TICKET MENU:\n" +
                "1. Buy ticket\n" +
                "2. Sell ticket\n" +
                "3. List of customer buying ticket\n" +
                "4. Stop selling ticket\n" +
                "5. Back to menu\n" +
                "6. Exit");
        System.out.print("Please choose function: ");
        String ticketIndex = scanner.nextLine();
        switch (ticketIndex) {
            case "1": {
                System.out.println("LIST OF CUSTOMERS");
                Customer customer = InputData.selectElementInList(customerList);
                waitingList.add(customer);
                System.out.println("add " + customer.showInfo() + "to waiting list successfully");
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                cinemaTicket();
                break;
            }
            case "2": {
                int soldTicket = 0;
                System.out.println("Number of customers in waiting list: " + waitingList.size());
                System.out.println("Number of tickets remaining: " + numTicket);
                System.out.print("Number of new tickets: ");
                numTicket += Integer.parseInt(scanner.nextLine());
                System.out.println("Total number of tickets: " + numTicket);
                while (numTicket > 0 && waitingList.size() > 0){
                    boughtTicketList.add(waitingList.remove());
                    numTicket--;
                    soldTicket++;
                }
                System.out.println("Number of sold ticket: " + soldTicket);
                System.out.println("Number of tickets remaining: " + numTicket);
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                cinemaTicket();
                break;
            }
            case "3": {
                System.out.println("LIST OF CUSTOMER BUYING TICKET: ");
                for (Customer customer : boughtTicketList){
                    System.out.println(customer.showInfo());
                }
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                cinemaTicket();
                break;
            }
            case "4": {
                //Stop selling ticket, clear all data in waitinglist, boughtTicketList and numberTicket remaining.
                boughtTicketList.clear();
                waitingList.clear();
                numTicket = 0;
                System.out.println("Stop selling ticket successfully");
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                cinemaTicket();
                break;
            }
            case "5": {
                displayMainMenu();
                break;
            }
            case "6": {
                System.exit(0);
            }
            default: {
                System.out.println("The index input is invalid. Please press ENTER to continue !!!");
                scanner.nextLine();
                cinemaTicket();
            }

        }
    }

    public static void main(String[] args) throws UserException {
        //Init bookingList. Read data from Booking.csv, add all customer booking villa, house, and room to the list
        bookingList = FileCsv.readBookingListFromCSV(BOOKING_FILE_PATH, VILLA_CODE, villaList);
        bookingList.addAll(FileCsv.readBookingListFromCSV(BOOKING_FILE_PATH, HOUSE_CODE, houseList));
        bookingList.addAll(FileCsv.readBookingListFromCSV(BOOKING_FILE_PATH, ROOM_CODE, roomList));

        displayMainMenu();
    }


}
