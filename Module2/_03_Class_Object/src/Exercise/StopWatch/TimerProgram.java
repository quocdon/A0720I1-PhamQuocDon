package Exercise.StopWatch;

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
            array[i] = (int) (Math.random()*100000);
        timer.getStartTime();
        sortArray(array);
        timer.getEndTime();
        double time = timer.getElapsedTime();
        System.out.println("Runtime = " + time + " ms");
        for (int i = 0; i < 15; i++){
            System.out.print(array[i] + "\t");
        }
    }
}
