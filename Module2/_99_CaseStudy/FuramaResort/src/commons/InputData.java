package commons;

import models.Customer;
import models.House;
import models.Room;
import models.Villa;

import java.util.List;
import java.util.Scanner;

import static Views.Main.*;
import static commons.CustomerValidate.*;

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
        } while (!ServiceValidate.checkVillaId(inputTemp) || !ServiceValidate.checkDuplicateId(inputTemp, villaList));
        villa.setId(inputTemp);
        do {
            System.out.print("2. Service Name: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkServiceName(inputTemp));
        villa.setServiceName(inputTemp);
        do {
            System.out.print("3. Area (>30m2): ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkArea(inputTemp));
        villa.setArea(Double.parseDouble(inputTemp));
        do {
            System.out.print("4. Rate: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkRate(inputTemp));
        villa.setRate(Double.parseDouble(inputTemp));
        do {
            System.out.print("5. Maximum Capacity (<20 persons): ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkMaxCapacity(inputTemp));
        villa.setMaxCapacity(Integer.parseInt(inputTemp));
        do {
            System.out.print("6. Rent Type (Year,Month,Week,Day): ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkRentType(inputTemp));
        villa.setRentType(inputTemp);
        do {
            System.out.print("7. Room Type: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkServiceName(inputTemp));
        villa.setRoomType(inputTemp);
        do {
            System.out.print("8. Comp Service (Massage,Karaoke,Food,Drink,Car): ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkCompService(inputTemp));
        villa.setCompService(inputTemp);
        do {
            System.out.print("9. Pool Area (>30m2): ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkArea(inputTemp));
        villa.setPoolArea(Double.parseDouble(inputTemp));
        do {
            System.out.print("10. Floor: ");
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
        } while (!ServiceValidate.checkHouseId(inputTemp) || !ServiceValidate.checkDuplicateId(inputTemp, houseList));
        house.setId(inputTemp);
        do {
            System.out.print("2. Service Name: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkServiceName(inputTemp));
        house.setServiceName(inputTemp);
        do {
            System.out.print("3. Area (>30m2): ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkArea(inputTemp));
        house.setArea(Double.parseDouble(inputTemp));
        do {
            System.out.print("4. Rate: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkRate(inputTemp));
        house.setRate(Double.parseDouble(inputTemp));
        do {
            System.out.print("5. Maximum Capacity (<20 persons): ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkMaxCapacity(inputTemp));
        house.setMaxCapacity(Integer.parseInt(inputTemp));
        do {
            System.out.print("6. Rent Type (Year,Month,Week,Day): ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkRentType(inputTemp));
        house.setRentType(inputTemp);
        do {
            System.out.print("7. Room Type: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkServiceName(inputTemp));
        house.setRoomType(inputTemp);
        do {
            System.out.print("8. Comp Service (Massage,Karaoke,Food,Drink,Car): ");
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
        } while (!ServiceValidate.checkRoomId(inputTemp) || !ServiceValidate.checkDuplicateId(inputTemp, roomList));
        room.setId(inputTemp);
        do {
            System.out.print("2. Service Name: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkServiceName(inputTemp));
        room.setServiceName(inputTemp);
        do {
            System.out.print("3. Area (>30m2): ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkArea(inputTemp));
        room.setArea(Double.parseDouble(inputTemp));
        do {
            System.out.print("4. Rate: ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkRate(inputTemp));
        room.setRate(Double.parseDouble(inputTemp));
        do {
            System.out.print("5. Maximum Capacity (<20 persons): ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkMaxCapacity(inputTemp));
        room.setMaxCapacity(Integer.parseInt(inputTemp));
        do {
            System.out.print("6. Rent Type (Year,Month,Week,Day): ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkRentType(inputTemp));
        room.setRentType(inputTemp);
        do {
            System.out.print("7. Comp Services (Massage,Karaoke,Food,Drink,Car): ");
            inputTemp = scanner.nextLine();
        } while (!ServiceValidate.checkCompService(inputTemp));
        room.setCompServices(inputTemp);
        return room;
    }

    public static Customer customer() {
        Customer customer = new Customer();
        String inputTemp;
        System.out.println("---------------");
        System.out.println("INPUT CUSTOMER INFORMATION:");
        do {
            System.out.print("1. Name: ");
            inputTemp = scanner.nextLine();
        } while (!checkName(inputTemp));
        customer.setName(inputTemp);
        do {
            System.out.print("2. Birthday: ");
            inputTemp = scanner.nextLine();
        } while (!checkBirthday(inputTemp));
        customer.setBirthday(inputTemp);
        do {
            System.out.print("3. Gender: ");
            inputTemp = scanner.nextLine();
        } while (!checkGender(inputTemp));
        //Format gender data (Male, Female, Unknown)
        String gender = "";
        gender = gender.concat(String.valueOf(Character.toUpperCase(inputTemp.charAt(0))));
        for (int i = 1; i < inputTemp.length(); i++) {
            gender = gender.concat(String.valueOf(Character.toLowerCase(inputTemp.charAt(i))));
        }
        customer.setGender(gender);
        do {
            System.out.print("4. ID: ");
            inputTemp = scanner.nextLine();
        } while (!checkId(inputTemp));
        customer.setId(inputTemp);
        do {
            System.out.print("5. Phone Number: ");
            inputTemp = scanner.nextLine();
        } while (!checkPhoneNumber(inputTemp));
        customer.setPhoneNumber(inputTemp);
        do {
            System.out.print("6. Email: ");
            inputTemp = scanner.nextLine();
        } while (!checkEmail(inputTemp));
        customer.setEmail(inputTemp);
        do {
            System.out.print("7. Customer Class: ");
            inputTemp = scanner.nextLine();
        } while (!checkCustomerClass(inputTemp));
        customer.setCustomerClass(inputTemp);
        System.out.print("8. Address: ");
        customer.setAddress(scanner.nextLine());
        customer.setBookedService(null);
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
