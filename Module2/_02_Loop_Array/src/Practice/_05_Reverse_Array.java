package Practice;

import java.util.Scanner;

public class _05_Reverse_Array {
    public static void reverse(int[] array){
        int temp;
        for (int i = 0; i < array.length/2; i++){
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + "\t");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size  = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++){
            System.out.printf("array[%d] = ", i);
            array[i] = scanner.nextInt();
        }
        System.out.println("The input array");
        printArray(array);
        reverse(array);
        System.out.println();
        System.out.println("The reversed array: ");
        printArray(array);
    }
}
