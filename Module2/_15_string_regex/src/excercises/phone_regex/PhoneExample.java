package excercises.phone_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneExample {
    public static boolean checkPhoneNumber(String str){
        String regex = "^[(][\\d]{2}[)]-[(]0[\\d]{9}[)]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String stringNumber = "(84-012365866";
        String stringNumber2 = "(84)-0123456789";
        String stringNumber3 = "(84)-(0978489648)";
        System.out.println(checkPhoneNumber(stringNumber));
        System.out.println(checkPhoneNumber(stringNumber2));
        System.out.println(checkPhoneNumber(stringNumber3));

    }
}
