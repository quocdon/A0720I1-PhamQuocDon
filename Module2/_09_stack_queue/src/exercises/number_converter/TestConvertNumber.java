package exercises.number_converter;

import java.util.Scanner;

public class TestConvertNumber {
    public static void main(String[] args) {
        int menuIndex;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number converter: \n1. Decimal to Binary & Hex\n2. Binary to Decimal & Hex\n3. Hex to Decimal & Binary\n");
        do {
            System.out.println("Enter number of function (1~3): ");
            menuIndex = Integer.valueOf(scanner.nextLine());
        } while (menuIndex < 0 || menuIndex > 3);
        switch (menuIndex) {
            case 1: {
                int value;
                do {
                    System.out.print("Input decimal value: ");
                    value = Integer.valueOf(scanner.nextLine());
                } while (!Decimal.isDecimal(value));
                Decimal decimal = new Decimal(value);
                System.out.println("Binary: " + decimal.toBinary().getValue());
                System.out.println("Hex: " + decimal.toHex().getValue());
                break;
            }
            case 2: {
                String value;
                do {
                    System.out.print("Input binary value: ");
                    value = scanner.nextLine();
                } while (!Binary.isBinary(value));
                Binary binary = new Binary(value);
                System.out.println("Decimal: " + binary.toDecimal().getValue());
                System.out.println("Hex: " + binary.toHex().getValue());
                break;
            }
            case 3: {
                String value;
                do {
                    System.out.print("Input hex value: ");
                    value = scanner.nextLine();
                } while (!Hex.isHex(value));
                Hex hex = new Hex(value);
                System.out.println("Decimal: " + hex.toDecimal().getValue());
                System.out.println("Binary: " + hex.toBinary().getValue());
                break;
            }
        }
    }
}
