package Exercise;

import java.util.Scanner;

public class _07_Max_2D_Array {
    public static int maxValue(int[][] array) {
        int max = array[0][0];
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++)
                if (array[i][j] > max)
                    max = array[i][j];

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of row: ");
        int row = scanner.nextInt();
        System.out.print("Enter number of column: ");
        int column = scanner.nextInt();
        int array[][] = new int[row][column];
        System.out.println("Input elements of array");
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++) {
                System.out.printf("Element [%d][%d] = ", i, j);
                array[i][j] = scanner.nextInt();
            }
        int max = maxValue(array);
        System.out.print("Maximum value of Array is: " + max);
    }
}
