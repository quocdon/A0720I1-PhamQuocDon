package controllers;

import models.House;
import models.Room;
import models.Services;
import models.Villa;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class WriteData {
    static Scanner scanner = new Scanner(System.in);
    public static void writeToFile(Services services, String source){
        /*This method use for writing service object to the file following the source link*/
        try {
            FileOutputStream fos = new FileOutputStream(source);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(services);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Write " + services.showInfo() + " successfully");
    }
    public static void villa() {
        //Users input information of service
        System.out.println("---------------");
        System.out.println("INPUT VILLA INFORMATION:");
        System.out.print("1. ID: ");
        String id = scanner.nextLine();
        System.out.print("2. Service Name: ");
        String serviceName = scanner.nextLine();
        System.out.print("3. Area: ");
        double area = Double.valueOf(scanner.nextLine());
        System.out.print("4. Rate: ");
        double rate = Double.valueOf(scanner.nextLine());
        System.out.print("Maximum Capacity: ");
        Integer maxCapacity = Integer.valueOf(scanner.nextLine());
        System.out.print("Rent Type: ");
        String rentType = scanner.nextLine();
        System.out.print("Room Type: ");
        String roomType = scanner.nextLine();
        System.out.print("Amenities: ");
        String amenities = scanner.nextLine();
        System.out.print("Pool Area: ");
        double poolArea = Double.valueOf(scanner.nextLine());
        System.out.print("Floor: ");
        int floor = Integer.valueOf(scanner.nextLine());

        //Villa service initialization
        Villa villa = new Villa(id, serviceName, area, rate, maxCapacity, rentType, roomType, amenities, poolArea, floor);

        //write room service to Villa.csv file
        writeToFile(villa, "src/data/Villa.csv");
    }
    public static void house() {
        //Users input information of service
        System.out.println("---------------");
        System.out.println("INPUT HOUSE INFORMATION:");
        System.out.print("1. ID: ");
        String id = scanner.nextLine();
        System.out.print("2. Service Name: ");
        String serviceName = scanner.nextLine();
        System.out.print("3. Area: ");
        double area = Double.valueOf(scanner.nextLine());
        System.out.print("4. Rate: ");
        double rate = Double.valueOf(scanner.nextLine());
        System.out.print("5. Maximum Capacity: ");
        Integer maxCapacity = Integer.valueOf(scanner.nextLine());
        System.out.print("6. Rent Type: ");
        String rentType = scanner.nextLine();
        System.out.print("7. Room Type: ");
        String roomType = scanner.nextLine();
        System.out.print("8. Amenities: ");
        String amenities = scanner.nextLine();
        System.out.print("9. Floor: ");
        int floor = Integer.valueOf(scanner.nextLine());

        //House service initialization
        House house = new House(id, serviceName, area, rate, maxCapacity, rentType, roomType, amenities, floor);

        //write room service to House.csv file
        writeToFile(house, "src/data/House.csv");
    }
    public static void room() {
        //Users input information of service
        System.out.println("---------------");
        System.out.println("INPUT ROOM INFORMATION:");
        scanner.skip("\n");
        System.out.print("1. ID: ");
        String id = scanner.nextLine();
        System.out.print("2. Service Name: ");
        String serviceName = scanner.nextLine();
        System.out.print("3. Area: ");
        double area = Double.valueOf(scanner.nextLine());
        System.out.print("4. Rate: ");
        double rate = Double.valueOf(scanner.nextLine());
        System.out.print("5. Maximum Capacity: ");
        Integer maxCapacity = Integer.valueOf(scanner.nextLine());
        System.out.print("6. Rent Type: ");
        String rentType = scanner.nextLine();
        System.out.print("7. Complimentary Services: ");
        String compServices = scanner.nextLine();

        //Room service initialization
        Room room = new Room(id, serviceName, area, rate, maxCapacity, rentType, compServices);

        //write room service to Room.csv file
        writeToFile(room, "src/data/Room.csv");
    }
}
