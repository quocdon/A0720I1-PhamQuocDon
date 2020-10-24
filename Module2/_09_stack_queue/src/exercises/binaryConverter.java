package exercises;

import java.util.Stack;

public class binaryConverter {
    public static String[] surPlusArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
    public static String decimalToBinary(int number) {
        Stack<Integer> surPlus = new Stack<>();
        while (number >= 1) {
            surPlus.push(number % 2);
            number /= 2;
        }
        String result = "(";
        while (!surPlus.isEmpty()) {
            result += String.valueOf(surPlus.pop());
        }
        result += ")B";
        return result;
    }

    public static String decimalToHexa(int number) {
        Stack<String> surPlus = new Stack<>();
        while (number >= 1) {
            surPlus.push(surPlusArray[number % 16]);
            number /= 16;
        }
        String result = "(";
        while (!surPlus.isEmpty()) {
            result += String.valueOf(surPlus.pop());
        }
        result += ")H";
        return result;
    }

    public static void main(String[] args) {
        String result1 = decimalToBinary(2991);
        String result2 = decimalToHexa(2991);
        System.out.println(result1);
        System.out.println(result2);
    }
}