package Practice;

import java.util.Scanner;

public class _06_Find_Element {
    public static int elementIndex(String element, String[] arr){
        for (int i = 0; i < arr.length; i++)
            if (arr[i].equals(element))
                return i;
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String inputName = scanner.nextLine();
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        int index = elementIndex(inputName, students);
        if (index == -1)
            System.out.println("Not found " + inputName + " in the list.");
        else System.out.println("Position of " + inputName + " in the list is: " + (index + 1));
    }
}
