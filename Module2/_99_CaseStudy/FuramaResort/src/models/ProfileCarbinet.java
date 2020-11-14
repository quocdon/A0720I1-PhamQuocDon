package models;

import java.util.Stack;

public class ProfileCarbinet {
    private Stack<Employee> employeeStack = new Stack<>();

    public ProfileCarbinet() {
    }

    public void add(Employee employee){
        employeeStack.add(employee);
    }

    public Employee search(String name){
        for (Employee employee: employeeStack){
            if (employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }
}
