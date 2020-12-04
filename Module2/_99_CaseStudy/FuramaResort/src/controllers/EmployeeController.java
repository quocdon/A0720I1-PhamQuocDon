package controllers;

import models.Employee;
import static Views.Main.*;

import static controllers.MainController.*;

public class EmployeeController {
    public static void showEmployee(){
        System.out.println("--------------------");
        System.out.println("LIST OF EMPLOYEE");
        for (String key : employeeHashMap.keySet()) {
            System.out.println(key + " - " + employeeHashMap.get(key));
        }
        System.out.println("Press ENTER to continue");
        scanner.nextLine();
        displayMainMenu();
    }

    public static void searchEmployee(){
        for (String key : employeeHashMap.keySet()) {
            profileCarbinet.add(employeeHashMap.get(key));
        }
        System.out.print("Input employee name: ");
        String name = scanner.nextLine();
        Employee employee = profileCarbinet.search(name);
        if (employee == null) {
            System.out.println("Employee profile not found");
        } else {
            System.out.println(employee.toString());
        }
        System.out.println("Press ENTER to continue");
        scanner.nextLine();
        displayMainMenu();
    }
}
