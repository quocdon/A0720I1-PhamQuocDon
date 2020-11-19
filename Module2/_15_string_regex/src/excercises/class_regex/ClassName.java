package excercises.class_regex;

import java.util.Scanner;

public class ClassName {
    public static boolean classValidate(String str){
        String regex = "^[CAP][\\d]{4}[G-M]$";
        if (str.matches(regex)){
            return true;
        } else return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter class name: ");
        String className = scanner.nextLine();
        System.out.println(classValidate(className));
    }
}
