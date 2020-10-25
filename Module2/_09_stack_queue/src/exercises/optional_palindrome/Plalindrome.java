package exercises.optional_palindrome;

import java.util.*;

public class Plalindrome {
    public static boolean isPalindrome(String text){
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0 ; i < text.length(); i++) {
            stack.addElement(String.valueOf(text.charAt(i)));
            queue.offer(String.valueOf(text.charAt(i)));
        }
        while (!stack.isEmpty()){
            if (!stack.pop().equals(queue.remove())){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        String inputText = scanner.nextLine();
        if (isPalindrome(inputText)){
            System.out.println("The text is palindrome");
        } else {
            System.out.println("The text is NOT palindrome");
        }
    }
}
