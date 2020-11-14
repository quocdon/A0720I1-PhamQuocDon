package controllers;

import models.Customer;
import models.House;
import models.Room;
import models.Villa;

import java.util.List;
import java.util.Scanner;

import static controllers.MainController.customerList;

public class InputData {
    static Scanner scanner = new Scanner(System.in);

    public static Villa villa() {
        Villa villa = new Villa();

        //Users input information of service
        System.out.println("---------------");
        System.out.println("INPUT VILLA INFORMATION:");
        System.out.print("1. ID: ");
        villa.setId(scanner.nextLine());
        System.out.print("2. Service Name: ");
        villa.setServiceName(scanner.nextLine());
        System.out.print("3. Area: ");
        villa.setArea(Double.valueOf(scanner.nextLine()));
        System.out.print("4. Rate: ");
        villa.setRate(Double.valueOf(scanner.nextLine()));
        System.out.print("Maximum Capacity: ");
        villa.setMaxCapacity(Integer.valueOf(scanner.nextLine()));
        System.out.print("Rent Type: ");
        villa.setRentType(scanner.nextLine());
        System.out.print("Room Type: ");
        villa.setRoomType(scanner.nextLine());
        System.out.print("Amenities: ");
        villa.setAmenities(scanner.nextLine());
        System.out.print("Pool Area: ");
        villa.setPoolArea(Double.valueOf(scanner.nextLine()));
        System.out.print("Floor: ");
        villa.setFloor(Integer.valueOf(scanner.nextLine()));
        return villa;
    }

    public static House house() {
        House house = new House();

        //Users input information of service
        System.out.println("---------------");
        System.out.println("INPUT HOUSE INFORMATION:");
        System.out.print("1. ID: ");
        house.setId(scanner.nextLine());
        System.out.print("2. Service Name: ");
        house.setServiceName(scanner.nextLine());
        System.out.print("3. Area: ");
        house.setArea(Double.valueOf(scanner.nextLine()));
        System.out.print("4. Rate: ");
        house.setRate(Double.valueOf(scanner.nextLine()));
        System.out.print("5. Maximum Capacity: ");
        house.setMaxCapacity(Integer.valueOf(scanner.nextLine()));
        System.out.print("6. Rent Type: ");
        house.setRentType(scanner.nextLine());
        System.out.print("7. Room Type: ");
        house.setRoomType(scanner.nextLine());
        System.out.print("8. Amenities: ");
        house.setAmenities(scanner.nextLine());
        System.out.print("9. Floor: ");
        house.setFloor(Integer.valueOf(scanner.nextLine()));
        return house;
    }

    public static Room room() {
        Room room = new Room();

        //Users input information of service
        System.out.println("---------------");
        System.out.println("INPUT ROOM INFORMATION:");
        System.out.print("1. ID: ");
        room.setId(scanner.nextLine());
        System.out.print("2. Service Name: ");
        room.setServiceName(scanner.nextLine());
        System.out.print("3. Area: ");
        room.setArea(Double.valueOf(scanner.nextLine()));
        System.out.print("4. Rate: ");
        room.setRate(Double.valueOf(scanner.nextLine()));
        System.out.print("5. Maximum Capacity: ");
        room.setMaxCapacity(Integer.valueOf(scanner.nextLine()));
        System.out.print("6. Rent Type: ");
        room.setRentType(scanner.nextLine());
        System.out.print("7. Complimentary Services: ");
        room.setCompServices(scanner.nextLine());

        return room;
    }

    public static Customer customer() {
        Customer customer = new Customer();

        System.out.println("---------------");
        System.out.println("INPUT CUSTOMER INFORMATION:");
        System.out.print("1. Name: ");
        customer.setName(scanner.nextLine());
        System.out.print("2. Birthday: ");
        customer.setBirthday(scanner.nextLine());
        System.out.print("3. Gender: ");
        customer.setGender(scanner.nextLine());
        System.out.print("4. ID: ");
        customer.setId(scanner.nextLine());
        System.out.print("5. Phone Number: ");
        customer.setPhoneNumber(scanner.nextLine());
        System.out.print("6. Email: ");
        customer.setEmail(scanner.nextLine());
        System.out.print("7. Customer Class: ");
        customer.setCustomerClass(scanner.nextLine());
        System.out.print("8. Address: ");
        customer.setAddress(scanner.nextLine());
        return customer;
    }

    public static <T> T selectElementInList(List<T> list) {
        // This method use for select element in a list

        int index;
        // Step 1: print all elements of the list with numbering by index of element + 1
        for (T element : list) {
            System.out.println((list.indexOf(element) + 1) + ". " + element.toString());
        }
        // Step 2: Choose element by input number from keyboard. The index of element = numberInput - 1
        // try again if the index is out of bound of the list
        do {
            System.out.print("Please choose element: ");
            index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index < 0 || index >= list.size()) {
                System.out.println("The index input is invalid. Please press ENTER to continue !!!");
                scanner.nextLine();
            }
        } while (index < 0 || index >= list.size());
        return list.get(index);
    }
}
