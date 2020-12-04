package controllers;

import commons.FileCsv;
import commons.InputData;
import models.House;
import models.Room;
import models.Services;
import models.Villa;

import java.util.List;
import java.util.TreeSet;

import static Views.Main.*;
import static controllers.MainController.displayMainMenu;

public class ServiceController {
    public static void addNewServices() {
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
            case "4":{
                displayMainMenu();
                break;
            }
            case "5":
                System.exit(0);
            default: {
                System.out.println("The index input is invalid. Please press ENTER to continue !!!");
                scanner.nextLine();
                addNewServices();
            }
        }
    }

    public static void showServices() {
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

    public static void showServiceNameNotDupicate(List<Services> serviceList) {
        TreeSet<String> serviceNameList = new TreeSet<>();
        for (Services service : serviceList) {
            serviceNameList.add(service.getServiceName());
        }
        System.out.println(serviceNameList.toString());
        System.out.println("Press ENTER to continue");
        scanner.nextLine();
    }
}
