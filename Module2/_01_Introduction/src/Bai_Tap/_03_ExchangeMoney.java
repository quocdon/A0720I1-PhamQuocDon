package Bai_Tap;

import java.util.Scanner;

public class _03_ExchangeMoney {
    public static void main(String[] args) {
        System.out.print("USD: ");
        Scanner scanner = new Scanner(System.in);
        double usd = scanner.nextFloat();
        double exchangeRate = 23000;
        double vnd = exchangeRate * usd;
        System.out.println("VND: " + vnd);
    }
}
