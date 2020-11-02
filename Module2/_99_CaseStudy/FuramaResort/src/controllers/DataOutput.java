package controllers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class DataOutput {
    public static void villa(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("INPUT VILLA INFORMATION:");
        System.out.print("1. ID: ");
        String id = scanner.nextLine();
        System.out.print("2. Service Name: ");
        String serviceName = scanner.nextLine();
        System.out.print("3. Area: ");
        double area = Double.valueOf(scanner.nextLine());
        System.out.print("4. Rate: ");
        double rate = Double.valueOf(scanner.nextLine());
        System.out.print("Service Name: ");
        String serviceName = scanner.nextLine();
        System.out.print("Service Name: ");
        String serviceName = scanner.nextLine();
        System.out.print("Service Name: ");
        String serviceName = scanner.nextLine();
        System.out.print("Service Name: ");
        try {
            FileOutputStream fos = new FileOutputStream("data/Villa.csv");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.wr
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
