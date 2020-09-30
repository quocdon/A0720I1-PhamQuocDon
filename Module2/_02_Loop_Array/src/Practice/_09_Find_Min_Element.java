package Practice;

import java.util.Scanner;

public class _09_Find_Min_Element {
    public static int minValue(int[] arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Input elements of array: ");
        for (int i = 0; i < array.length; i++){
            System.out.printf("array[%d] = " , i);
            array[i] = scanner.nextInt();
        }
        int minElement = minValue(array);
        System.out.println("Min element of array is " + minElement);
    }
}
