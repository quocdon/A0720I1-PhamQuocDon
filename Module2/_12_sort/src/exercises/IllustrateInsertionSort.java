package exercises;

public class IllustrateInsertionSort {
    public static void insertionSort(int[] arr) {
        for (int e : arr){
            System.out.print(e + " ");
        }
        System.out.println();
        for (int i = 1; i < arr.length; i++) {
            int currentElement = arr[i];
            int k;
            for (k = i - 1; k >= 0 && arr[k] > currentElement; k--) {
                arr[k + 1] = arr[k];
            }
            if (arr[k + 1] != currentElement){
                System.out.println("Insert " + currentElement + " before " + arr[k + 1]);
            } else {
                System.out.println("Keep position of " + currentElement);
            }

            arr[k + 1] = currentElement;
            System.out.print("Result: " );
            for (int e : arr){
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] list = {4, 2, 5, 10, 55, 6, 1};
        insertionSort(list);
    }
}
