package Exercise;

import java.util.Scanner;

public class _04_Delete_Element_Array {
    public static int[] deleteElement(int element, int[] array) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == element){
                for (int j = i; j < array.length-1; j++)
                    array[j] = array[j+1];
                array[array.length - 1] = 0;
                break;
            }
        return array;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of Array: ");
        int size = scanner.nextInt();
        int array [] = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Input element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        System.out.print("Enter element delete: ");
        int element = scanner.nextInt();
        array = deleteElement(element, array);
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + "\t");
    }
}
