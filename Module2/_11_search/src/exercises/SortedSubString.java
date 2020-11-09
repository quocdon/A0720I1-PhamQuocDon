package exercises;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SortedSubString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string: ");
        String string = scanner.nextLine();
        List<Character> maxSubString = new LinkedList<>();
        LinkedList<Character> subString = new LinkedList<>();
        for (int i = 0; i < string.length(); i++){
            Character chr = string.charAt(i);
            if (subString.size() > 0 && chr <= subString.getLast()){
                subString.clear();
            }
            subString.add(chr);
            if (subString.size() > maxSubString.size()){
                maxSubString.clear();
                maxSubString.addAll(subString);
            }
        }
        for (Character chr : maxSubString){
            System.out.print(chr);
        }
    }
}
