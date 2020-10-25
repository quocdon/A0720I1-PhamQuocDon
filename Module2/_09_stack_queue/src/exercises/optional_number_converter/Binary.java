package exercises.optional_number_converter;

import java.util.Stack;

public class Binary {
    private String value;

    public Binary(){
        this.value = "0";
    }

    public Binary(String value) {
        if (value.isEmpty()){
            this.value = "0";
        } else this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Decimal toDecimal(){
        int result = 0;
        int power = 0;
        Stack<String> surPlus = new Stack<>();
        for (int i = 0; i < this.value.length(); i++) {
            surPlus.push(String.valueOf(this.value.charAt(i)));
        }
        while (!surPlus.isEmpty()) {
            result += Integer.valueOf(surPlus.pop()) * Math.pow(2, power);
            power++;
        }
        Decimal decimal = new Decimal(result);
        return decimal;
    }

    public Hex toHex(){
        Decimal decimalNumber = this.toDecimal();
        return decimalNumber.toHex();
    }

    public static boolean isBinary(String number){
        for (int i = 0; i < number.length(); i++) {
            if (!number.substring(i, i + 1).equals("1") && !number.substring(i, i + 1).equals("0")) {
                return false;
            }
        }
        return true;
    }
}
