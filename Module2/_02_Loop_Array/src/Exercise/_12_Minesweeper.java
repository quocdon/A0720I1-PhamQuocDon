package Exercise;

import java.util.Scanner;

public class _12_Minesweeper {
    public static String neighbors(String[][] arr, int x, int y) {
        final int HEIGHT = arr.length;
        final int WIDTH = arr[0].length;
        int mineCount = 0;
        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++)
                if (x + i < 0 || x + i >= HEIGHT || y + j < 0 || y + j >= WIDTH)
                    continue;
                else if (arr[x + i][y + j].equals("*"))
                    mineCount++;
        return String.valueOf(mineCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input height of map: ");
        int height = scanner.nextInt();
        System.out.print("Input width of map: ");
        int width = scanner.nextInt();
        String[][] inputMap = new String[height][width];
        System.out.println("Only input * or . to the cell");
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
                do {
                    System.out.printf("cell[%d}[%d]= ", i, j);
                    inputMap[i][j] = scanner.next();
                } while (!inputMap[i][j].equals("*") && !inputMap[i][j].equals("."));
            }
        String[][] outputMap = new String[height][width];
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                if (inputMap[i][j].equals("*"))
                    outputMap[i][j] = "*";
                else outputMap[i][j] = neighbors(inputMap, i, j);
        System.out.println("Mine map input: ");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
                System.out.print(inputMap[i][j]);
            System.out.println();
        }
        System.out.println("Mine map output: ");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
                System.out.print(outputMap[i][j]);
            System.out.println();
        }
    }
}
