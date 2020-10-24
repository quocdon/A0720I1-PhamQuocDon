package exercises;

import java.util.Stack;

public class ReversedArray {
    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>();
        int[] intArr = {1, 2, 3, 4};
        for (int i = 0; i < intArr.length; i++) {
            intStack.push(intArr[i]);
        }
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = intStack.pop();
        }
        for (int i = 0; i < intArr.length; i++) {
            System.out.print(intArr[i] + "\t");
        }

    }
}
