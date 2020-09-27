package Exercise;

import java.util.Scanner;

public class _08_Min_Of_Array {
    public static int minOfArray(int[] array){
        int min = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i] < min)
                min = array[i];
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++){
            System.out.printf("array[%d] = ", i);
            array[i] = scanner.nextInt();
        }
        int min = minOfArray(array);
        System.out.print("Min of Array is " + min);
    }
}
