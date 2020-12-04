package Views;

import commons.FileCsv;
import models.Customer;
import models.Employee;
import models.ProfileCarbinet;
import models.Services;

import java.util.*;

import static controllers.MainController.*;

public class Main {
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
    public static final String COMMA = ",";
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
    public static void main(String[] args) {
        //Read service list data from CSV file
        villaList = FileCsv.readServiceListFromCSV(VILLA_FILE_PATH);
        houseList = FileCsv.readServiceListFromCSV(HOUSE_FILE_PATH);
        roomList = FileCsv.readServiceListFromCSV(ROOM_FILE_PATH);
        //read customerList data from CSV file.
        customerList = FileCsv.readCustomerListFromCSV(CUSTOMER_FILE_PATH, VILLA_CODE, villaList);
        customerList.addAll(FileCsv.readCustomerListFromCSV(CUSTOMER_FILE_PATH, HOUSE_CODE, houseList));
        customerList.addAll(FileCsv.readCustomerListFromCSV(CUSTOMER_FILE_PATH, ROOM_CODE, roomList));
        customerList.addAll(FileCsv.readCustomerListFromCSV(CUSTOMER_FILE_PATH, "null", null));
        //Read Employee data from CSV file
        employeeHashMap = FileCsv.readEmployeeFromCSV(EMPLOYEE_FILE_PATH);
        //list all customers who have booked service != null to bookingList
        for (Customer customer : customerList){
            if (customer.getBookedService() != null){
                bookingList.add(customer);
            }
        }
        displayMainMenu();
    }
}
