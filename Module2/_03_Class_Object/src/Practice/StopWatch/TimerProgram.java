package Practice.StopWatch;

import java.util.Date;
import java.util.Random;

public class TimerProgram {
    public static void sortArray(int arr[]){
        for (int i = 0; i < arr.length - 1 ; i++)
            for (int j = i+1; j < arr.length; j++)
                if (arr[i] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
    }
    public static void main(String[] args) {
        StopWatch timer = new StopWatch();
        Random rd = new Random();
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++)
            array[i] = rd.nextInt();
        Date start = timer.getStartTime();
        sortArray(array);
        Date end = timer.getEndTime();
        long time = timer.getElapsedTime(start, end);
        System.out.print("Rumetime = " + time + " ms");
    }
}
