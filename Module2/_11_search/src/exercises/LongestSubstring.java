package exercises;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LongestSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String: ");
        String string = scanner.nextLine();
        List<Character> longestSubstring = new LinkedList<>();
        List<Character> substring = new LinkedList<>();
        int index = 0;
        while (index < string.length()) {
            if (substring.isEmpty()) {
                substring.add(string.charAt(index));
            } else {
                if (substring.get(substring.size() - 1) <= string.charAt(index)) {
                    substring.add(string.charAt(index));
                } else {
                    if (substring.size() > longestSubstring.size()) {
                        longestSubstring.clear();
                        longestSubstring.addAll(substring);
                    }
                    substring.clear();
                    substring.add(string.charAt(index));
                }
                if (index == string.length() - 1 && substring.size() > longestSubstring.size()) {
                    longestSubstring.clear();
                    longestSubstring.addAll(substring);
                }
            }
            index++;
        }
        for (int i = 0; i < longestSubstring.size(); i++){
            System.out.print(longestSubstring.get(i));
        }
    }
}
