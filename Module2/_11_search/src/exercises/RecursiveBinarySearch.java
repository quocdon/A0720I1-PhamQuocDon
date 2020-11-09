package exercises;

public class RecursiveBinarySearch {
    public static int RecSearch(int[] array, int head, int tail, int value) {
        if (head <= tail) {
            int mid = head + (tail - head) / 2;
            if (value > array[mid]) {
                return RecSearch(array, mid + 1, tail, value);
            } else if (value < array[mid]) {
                return RecSearch(array, head, mid - 1, value);
            } else return mid;
        }
        return -1;
    }

    public static int RecBinarySearch(int[] array, int value) {
        int head = 0;
        int tail = array.length - 1;
        return RecSearch(array, head, tail, value);
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 4, 5, 7, 8, 10, 12};
        int value = 7;
        System.out.println(RecBinarySearch(sortedArray, value));
    }
}
