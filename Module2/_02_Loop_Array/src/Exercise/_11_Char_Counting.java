package Exercise;

import java.util.Scanner;

public class _11_Char_Counting {
    public static int charCount(String str, char chr){
        int count = 0;
        for (int i = 0; i < str.length(); i++)
            if (chr == str.charAt(i))
                count++;
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string: ");
        String str = scanner.nextLine();
        System.out.println("Input character: ");
        char chr = scanner.next().charAt(0);
        int count = charCount(str, chr);
        System.out.print("count " + chr + " : " + count);
    }
}
