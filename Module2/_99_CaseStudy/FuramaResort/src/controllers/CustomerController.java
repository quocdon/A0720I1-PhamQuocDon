package controllers;

import commons.FileCsv;
import commons.InputData;
import commons.SortCustomerByNameBirthday;
import models.Customer;

import java.util.Collections;

import static Views.Main.*;
import static controllers.MainController.*;

public class CustomerController {
    public static void addNewCustomer() {
        Customer customer = InputData.customer();
        customerList.add(customer);
        FileCsv.writeCustomerToCSV(customerList, CUSTOMER_FILE_PATH);
        System.out.println("Add " + customer.showInfo() + " successfully");
        System.out.println("Press ENTER to continue");
        scanner.nextLine();
        displayMainMenu();
    }

    public static void showCustomerList(){
        SortCustomerByNameBirthday sortCustomerByNameBirthday = new SortCustomerByNameBirthday();
        Collections.sort(customerList, sortCustomerByNameBirthday);
        System.out.println("-----------------");
        System.out.println("LIST OF CUSTOMERS");
        for (Customer customer : customerList) {
            System.out.println(customer.showInfo());
        }
        System.out.println("Press ENTER to continue");
        scanner.nextLine();
        displayMainMenu();
    }
}
