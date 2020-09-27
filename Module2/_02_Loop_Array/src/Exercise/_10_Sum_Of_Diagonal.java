package Exercise;

import java.util.Scanner;

public class _10_Sum_Of_Diagonal {
    public static int sumOfDiagonal(int arr[][]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i][i];
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size = scanner.nextInt();
        int array[][] = new int[size][size];
        System.out.println("Input elements of array");
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                System.out.printf("Element [%d][%d] = ", i, j);
                array[i][j] = scanner.nextInt();
            }
        int sum = sumOfDiagonal(array);
        System.out.print("Sum of all elements on main diagonal is: " + sum);

    }
}
