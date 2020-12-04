package controllers;

import commons.FileCsv;
import commons.InputData;
import models.Customer;
import models.Services;

import static Views.Main.*;
import static controllers.MainController.*;

public class BookingController {
    public static void addNewBooking() {
        System.out.println("--------------");
        System.out.println("ADD NEW BOOKING");
        System.out.println("LIST OF CUSTOMERS");
        Customer customer = InputData.selectElementInList(customerList);
        System.out.println("Customer: " + customer.getName() + " - " + customer.getBirthday() + " - " + customer.getId());
        System.out.print("LIST OF SERVICES: \n" +
                "1. Booking Villa\n" +
                "2. Booking House\n" +
                "3. Booking Room\n" +
                "Please choose function: ");
        String bookingIndex = scanner.nextLine();
        switch (bookingIndex) {
            case "1": {
                Services service = InputData.selectElementInList(villaList);
                if (bookingList.contains(customer)){
                    customer.setBookedService(service);
                } else {
                    customer.setBookedService(service);
                    bookingList.add(customer);
                }
                FileCsv.writeCustomerToCSV(customerList,CUSTOMER_FILE_PATH);
                FileCsv.writeBookingToCSV(bookingList, BOOKING_FILE_PATH);
                System.out.println("Add " + customer.showInfo() + " successfully");
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                displayMainMenu();
                break;
            }
            case "2": {
                Services service = InputData.selectElementInList(houseList);
                if (bookingList.contains(customer)){
                    customer.setBookedService(service);
                } else {
                    customer.setBookedService(service);
                    bookingList.add(customer);
                }
                FileCsv.writeCustomerToCSV(customerList,CUSTOMER_FILE_PATH);
                FileCsv.writeBookingToCSV(bookingList, BOOKING_FILE_PATH);
                System.out.println("Add " + customer.showInfo() + " successfully");
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                displayMainMenu();
                break;
            }
            case "3": {
                Services service = InputData.selectElementInList(roomList);
                if (bookingList.contains(customer)){
                    customer.setBookedService(service);
                } else {
                    customer.setBookedService(service);
                    bookingList.add(customer);
                }
                FileCsv.writeCustomerToCSV(customerList,CUSTOMER_FILE_PATH);
                FileCsv.writeBookingToCSV(bookingList, BOOKING_FILE_PATH);
                System.out.println("Add " + customer.showInfo() + " successfully");
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
}
