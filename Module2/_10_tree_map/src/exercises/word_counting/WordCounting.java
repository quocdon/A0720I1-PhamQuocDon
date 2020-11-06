package exercises.word_counting;

import java.util.*;

public class WordCounting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String: ");
        String inputString = scanner.nextLine();
        inputString = inputString.trim().toLowerCase();
        String[] stringArrray = inputString.split("\\s+");
        Map<String, Integer> wordMap = new HashMap<String, Integer>();

        for (String string : stringArrray) {
            if (wordMap.containsKey(string)) {
                Integer newValue = wordMap.get(string) + 1;
                wordMap.put(string, newValue);
            } else {
                wordMap.put(string, 1);
            }
        }

        for (String key : wordMap.keySet()) {
            System.out.println(key + " : " + wordMap.get(key));
        }

    }
}
