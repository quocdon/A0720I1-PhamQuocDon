package Views;

import commons.FileCsv;
import models.Customer;

import static controllers.MainController.*;

public class Main {
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
