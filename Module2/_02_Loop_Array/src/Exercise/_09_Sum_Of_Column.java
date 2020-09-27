package Exercise;

import java.util.Scanner;

public class _09_Sum_Of_Column {
    public static double sumOfColumn(int column, double arr[][]) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i][column];
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of row: ");
        int row = scanner.nextInt();
        System.out.print("Enter number of column: ");
        int column = scanner.nextInt();
        double array[][] = new double[row][column];
        System.out.println("Input elements of array");
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++) {
                System.out.printf("Element [%d][%d] = ", i, j);
                array[i][j] = scanner.nextInt();
            }
        System.out.print("Input index of column which you want to calculate sum: ");
        int sumColumn = scanner.nextInt();
        if (sumColumn < 0 || sumColumn >= column){
            System.out.print("Invalid column");
        } else {
            double sum = sumOfColumn(sumColumn, array);
            System.out.print("Sum of all elements in column " + sumColumn + ": " + sum);
        }

    }

}
