package controllers;

import models.House;
import models.Room;
import models.Services;
import models.Villa;

import java.util.List;
import java.util.Scanner;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);
    static final String VILLA_FILE_PATH = "src/data/Villa.csv";
    static final String HOUSE_FILE_PATH= "src/data/House.csv";
    static final String ROOM_FILE_PATH = "src/data/Room.csv";
    private static List<Services> villaList = FileCsv.readServiceListFromCSV(VILLA_FILE_PATH);
    private static List<Services> houseList = FileCsv.readServiceListFromCSV(HOUSE_FILE_PATH);
    private static List<Services> roomList = FileCsv.readServiceListFromCSV(ROOM_FILE_PATH);
    public static void displayMainMenu() {
        System.out.print("---------------\nMAIN MENU: \n" +
                "1. Add new services\n" +
                "2. Show services\n" +
                "3. Add new customer\n" +
                "4. Show information of customer\n" +
                "5. Add new booking\n" +
                "6. Show information of Employee\n" +
                "7. Exit\n" +
                "Please choose the function: ");
        String mainMenuIndex = scanner.nextLine();
        switch (mainMenuIndex) {
            case "1":
                addNewServices();
                break;
            case "2":{
                showServices();
                break;
            }
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
                System.exit(0);
            default:
                System.out.println("The index input is invalid. Please press ENTER to continue !!!");
                scanner.nextLine();
                displayMainMenu();
        }
    }
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
                Villa villa = InputServices.villa();
                villaList.add(villa);
                FileCsv.writeServicesToCSV(villaList, VILLA_FILE_PATH);
                System.out.println("Add " + villa.showInfo() + " successfully");
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                addNewServices();
                break;
            }
            case "2": {
                House house = InputServices.house();
                houseList.add(house);
                FileCsv.writeServicesToCSV(houseList,HOUSE_FILE_PATH);
                System.out.println("Add " + house.showInfo() + " successfully");
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                addNewServices();
                break;
            }
            case "3":{
                Room room = InputServices.room();
                roomList.add(room);
                FileCsv.writeServicesToCSV(roomList,ROOM_FILE_PATH);
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

    public static void showServices(){
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
                for (Services services: villaList){
                    System.out.println(services.showInfo());
                }
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                showServices();
                break;
            }
            case "2": {
                for (Services services: houseList){
                    System.out.println(services.showInfo());
                }
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                showServices();
                break;
            }
            case "3": {
                for (Services services: roomList){
                    System.out.println(services.showInfo());
                }
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                showServices();
                break;
            }
            case "4":
            case "5":
            case "6":
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

    public static void main(String[] args) {
        displayMainMenu();
    }
}
