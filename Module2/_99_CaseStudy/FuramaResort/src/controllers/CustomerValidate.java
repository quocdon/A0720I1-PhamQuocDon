package controllers;

import commons.NameException;
import commons.UserException;

import java.util.Date;

public class CustomerValidate {
    private static String regex = "";

    public static boolean checkName(String str) {
        regex = "^[A-Z][a-z]{0,}([\\s]{1}[A-Z][a-z]{0,})*$";
        boolean flag = str.matches(regex);
        try {

            if (!flag){
                throw new NameException("Invalid Name. Please input again (for example: Nguyen Van An")
            }
        } catch (UserException ex){
            System.out.println(ex.getMessage());
        }
        return str.matches(regex);
    }

    public static boolean checkEmail(String str) {
        regex = "^[\\w\\d-_.]{3,20}@[\\w]{3,15}(.[\\w]{2,8}){1,3}$";
        return str.matches(regex);
    }

    public static boolean checkGender(String str) {
        regex = "^male|female|unknown$";
        String lowerCaseStr = str.toLowerCase();
        return lowerCaseStr.matches(regex);
    }

    public static boolean checkId(String str) {
        regex = "^[\\d]{3}[\\s]{1}[\\d]{3}[\\s]{1}[\\d]{3}$";
        return str.matches(regex);
    }

    public static boolean checkBirthday(String str){
        regex = "^[\\d]{2}\\/[\\d]{2}\\/[\\d]{4}$";
        boolean flag = str.matches(regex);
        if (flag) {
            int day = Integer.parseInt(str.substring(0,2));
            int month = Integer.parseInt(str.substring(3,5));
            int year = Integer.parseInt(str.substring(6,10));
            Date today = new Date();
            try {
                Date birthday = new Date(day, month, year);
            } catch (Exception e) {
                return false;
            }
            if (year < 1900 || today.getYear() - year < 18 ){
                return false;
            }
        } else {
            return flag;
        }
        return true;
    }
}
