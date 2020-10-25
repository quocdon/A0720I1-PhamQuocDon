package exercises.optionnal_bracket;

import java.util.Scanner;
import java.util.Stack;

public class CheckBracket {
    public static boolean isGoodBracket(String expression){
        Stack<Integer> bracketStack = new Stack<>();
        for (int i = 0; i < expression.length(); i++){
            if (String.valueOf(expression.charAt(i)).equals("(")){
                bracketStack.push(i);
            } else if (String.valueOf(expression.charAt(i)).equals(")")){
                if (bracketStack.isEmpty() || String.valueOf(expression.charAt(i-1)).equals("(")){
                    return false;
                } else {
                    bracketStack.pop();
                }
            }
        }
        if (bracketStack.isEmpty()){
            return true;
        } else return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter expression: ");
        String expression = scanner.nextLine();
        System.out.println(isGoodBracket(expression));
    }
}
