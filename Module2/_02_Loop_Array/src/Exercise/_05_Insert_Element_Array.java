package Exercise;

import java.util.Scanner;

public class _05_Insert_Element_Array {
    public static int[] insertElement(int element, int index, int[] array) {
        for (int i = index; i < array.length - 1; i++)
            array[i + 1] = array[i];
        array[index] = element;

        return array;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of Array: ");
        int size = scanner.nextInt();
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Input element at index " + (i) + ": ");
            array[i] = scanner.nextInt();
        }
        System.out.print("Enter element inserted: ");
        int element = scanner.nextInt();
        System.out.print("Enter index inserted: ");
        int index = scanner.nextInt();
        array = insertElement(element, index, array);
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + "\t");
    }
}
