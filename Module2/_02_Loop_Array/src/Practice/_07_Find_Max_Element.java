package Practice;

import java.util.Scanner;

public class _07_Find_Max_Element {
    public static int max(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
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
        int maxElement = max(array);
        System.out.println("Max element of array is " + maxElement);

    }
}
