package exercises;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currentElement = arr[i];
            int k;
            for (k = i - 1; k >= 0 && arr[k] > currentElement; k--) {
                arr[k + 1] = arr[k];
            }
            arr[k + 1] = currentElement;
        }
    }

    public static void main(String[] args) {
        int[] list = {4, 2, 5, 1, 6, 8, 3};
        insertionSort(list);
        for (int e : list) {
            System.out.print(e + ", ");
        }
    }
}
