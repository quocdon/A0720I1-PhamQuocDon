package controllers;

import commons.NameException;
import commons.UserException;
import models.Customer;
import models.House;
import models.Room;
import models.Villa;

import java.util.List;
import java.util.Scanner;

public class InputData {
    static Scanner scanner = new Scanner(System.in);

    public static Villa villa() {
        Villa villa = new Villa();
        String inputTemp;

        //Users input information of service
        System.out.println("---------------");
        System.out.println("INPUT VILLA INFORMATION:");
        do {
            System.out.print("1. ID: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkVillaId(inputTemp));
        villa.setId(inputTemp);
        do {
            System.out.print("2. Service Name: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkServiceName(inputTemp));
        villa.setServiceName(inputTemp);
        do {
            System.out.print("3. Area: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkArea(inputTemp));
        villa.setArea(Double.parseDouble(inputTemp));
        do {
            System.out.print("4. Rate: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkRate(inputTemp));
        villa.setRate(Double.parseDouble(inputTemp));
        do {
            System.out.print("Maximum Capacity: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkMaxCapacity(inputTemp));
        villa.setMaxCapacity(Integer.parseInt(inputTemp));
        do {
            System.out.print("Rent Type: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkServiceName(inputTemp));
        villa.setRentType(inputTemp);
        do {
            System.out.print("Room Type: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkServiceName(inputTemp));

        villa.setRoomType(scanner.nextLine());
        do {
            System.out.print("Comp Service: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkCompService(inputTemp));
        villa.setCompService(inputTemp);
        do {
            System.out.print("Pool Area: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkPoolArea(inputTemp));
        villa.setPoolArea(Double.parseDouble(inputTemp));
        do {
            System.out.print("Floor: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkFloor(inputTemp));
        villa.setFloor(Integer.parseInt(inputTemp));
        return villa;
    }

    public static House house() {
        House house = new House();
        String inputTemp;

        //Users input information of service
        System.out.println("---------------");
        System.out.println("INPUT HOUSE INFORMATION:");
        do {
            System.out.print("1. ID: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkHouseId(inputTemp));
        house.setId(inputTemp);
        do {
            System.out.print("2. Service Name: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkServiceName(inputTemp));
        house.setServiceName(inputTemp);
        do {
            System.out.print("3. Area: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkArea(inputTemp));
        house.setArea(Double.parseDouble(inputTemp));
        do {
            System.out.print("4. Rate: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkRate(inputTemp));
        house.setRate(Double.parseDouble(inputTemp));
        do {
            System.out.print("5. Maximum Capacity: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkMaxCapacity(inputTemp));
        house.setMaxCapacity(Integer.parseInt(inputTemp));
        do {
            System.out.print("6. Rent Type: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkServiceName(inputTemp));
        house.setRentType(inputTemp);
        do {
            System.out.print("7. Room Type: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkServiceName(inputTemp));
        house.setRoomType(inputTemp);
        do {
            System.out.print("8. Comp Service: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkCompService(inputTemp));
        house.setCompService(inputTemp);
        do {
            System.out.print("9. Floor: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkFloor(inputTemp));
        house.setFloor(Integer.parseInt(inputTemp));
        return house;
    }

    public static Room room() {
        Room room = new Room();
        String inputTemp;

        //Users input information of service
        System.out.println("---------------");
        System.out.println("INPUT ROOM INFORMATION:");
        do {
            System.out.print("1. ID: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkRoomId(inputTemp));
        room.setId(inputTemp);
        do {
            System.out.print("2. Service Name: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkServiceName(inputTemp));
        room.setServiceName(inputTemp);
        do {
            System.out.print("3. Area: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkArea(inputTemp));
        room.setArea(Double.parseDouble(inputTemp));
        do {
            System.out.print("4. Rate: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkRate(inputTemp));
        room.setRate(Double.parseDouble(inputTemp));
        do {
            System.out.print("5. Maximum Capacity: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkMaxCapacity(inputTemp));
        room.setMaxCapacity(Integer.parseInt(inputTemp));
        do {
            System.out.print("6. Rent Type: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkServiceName(inputTemp));
        room.setRentType(inputTemp);
        do {
            System.out.print("7. Complimentary Services: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkCompService(inputTemp));
        room.setCompServices(inputTemp);
        return room;
    }

    public static Customer customer() throws UserException {
        Customer customer = new Customer();
        String inputTemp;
        System.out.println("---------------");
        System.out.println("INPUT CUSTOMER INFORMATION:");
        try {
            System.out.print("1. Name: ");
            inputTemp = scanner.nextLine();
            if (!CustomerValidate.checkName(inputTemp)){
                throw new NameException("Invalid name. Please input again (Example: Pham Van An)");
            }
            customer.setName(inputTemp);
        } catch (NameException ex){
            System.out.println(ex.getMessage());
            System.out.print("1. Name: ");
            inputTemp = scanner.nextLine();
        }
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
        // This method use to select element in a list

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
