package Bai_Tap;

import java.net.SocketOption;
import java.util.Scanner;

public class _02_NumberReading {
    public static void main(String[] args) {
        System.out.print("Please enter number (0-999): ");
        Scanner scanner = new Scanner(System.in);
        short number = scanner.nextShort();
        String hundredsReading = "", tensReading = "", digitReading = "";
        if (number <= 999 && number >= 0){
            int hundreds = number / 100;
            int tens = (number % 100)/10;
            int digit = number % 10;
            switch (hundreds){
                case 0: hundredsReading = ""; break;
                case 1: hundredsReading = "One hundred"; break;
                case 2: hundredsReading = "Two hundreds"; break;
                case 3: hundredsReading = "Three hundred"; break;
                case 4: hundredsReading = "Four hundred"; break;
                case 5: hundredsReading = "Five hundred"; break;
                case 6: hundredsReading = "Six hundred"; break;
                case 7: hundredsReading = "Seven hundred"; break;
                case 8: hundredsReading = "Eight hundred"; break;
                case 9: hundredsReading = "Nine hundred"; break;

            }
            if (tens >= 2){
                switch (tens){
                    case 2: tensReading = "twenty"; break;
                    case 3: tensReading = "thirty"; break;
                    case 4: tensReading = "fourty"; break;
                    case 5: tensReading = "fifty"; break;
                    case 6: tensReading = "sixty"; break;
                    case 7: tensReading = "seventy"; break;
                    case 8: tensReading = "eighty"; break;
                    case 9: tensReading = "ninety"; break;
                }
            } else if (tens == 1){
                switch (digit){
                    case 0: tensReading = "ten"; break;
                    case 1: tensReading = "eleven"; break;
                    case 2: tensReading = "twelve"; break;
                    case 3: tensReading = "thirteen"; break;
                    case 4: tensReading = "fourteen"; break;
                    case 5: tensReading = "fifteen"; break;
                    case 6: tensReading = "sixteen"; break;
                    case 7: tensReading = "seventeen"; break;
                    case 8: tensReading = "eightteen"; break;
                    case 9: tensReading = "nineteen";
                }
            }
            if (tens >=2 || tens != 1){
                switch (digit){
                    case 0: {
                        if (number == 0){
                            digitReading = "zero";
                        } else {
                            digitReading = "";
                        }
                        break;
                    }
                    case 1: digitReading = "one"; break;
                    case 2: digitReading = "two"; break;
                    case 3: digitReading = "three"; break;
                    case 4: digitReading = "four"; break;
                    case 5: digitReading = "five"; break;
                    case 6: digitReading = "six"; break;
                    case 7: digitReading = "seven"; break;
                    case 8: digitReading = "eight"; break;
                    case 9: digitReading = "nine";
                }
            }
            if (hundreds != 0 && (tens != 0 || digit != 0)){
                hundredsReading += " and ";
            }
            if (tens != 0 && digit != 0){
                tensReading += " ";
            }
            System.out.print(hundredsReading + tensReading + digitReading);
        } else {
            System.out.print("Out of range");
        }

    }
}
