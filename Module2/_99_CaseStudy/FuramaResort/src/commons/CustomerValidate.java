package commons;

import exceptions.*;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidate {
    public static boolean checkName(String str) {
        String regex = "^[A-Z][a-z]{0,}([\\s]{1}[A-Z][a-z]{0,})*$";
        boolean check = str.matches(regex);
        try {
            if (!check){
                throw new NameException("Invalid name. Please input again (Exp: Nguyen Van An)");
            }
        } catch (NameException e){
            System.out.println(e.getMessage());
        }
        return check;
    }
    public static boolean checkBirthday(String str) {
        String regex = "^[\\d]{2}\\/[\\d]{2}\\/[\\d]{4}$";
        boolean check = str.matches(regex);
        try {
            if (check) {
                int day = Integer.parseInt(str.substring(0, 2));
                int month = Integer.parseInt(str.substring(3, 5));
                int year = Integer.parseInt(str.substring(6, 10));
                LocalDate today = LocalDate.now();
                LocalDate birthday;
                try {
                    birthday = LocalDate.of(year, month, day);
                } catch (Exception e) {
                    throw new BirthdayException("Invalid date. Please input again");
                }
                if (year <= 1900) {
                    throw new BirthdayException("The year of birthday must be greater than 1900");
                }
                if (Period.between(birthday, today).getYears() < 18) {
                    throw new BirthdayException("Under 18 years old customer is NOT permitted");
                }
            } else {
                throw new BirthdayException("Invalid date. Please input again (Birthday format: dd/mm/yyyy)");
            }
        } catch (BirthdayException e) {
            System.out.println(e.getMessage());
            check = false;
        }
        return check;
    }

    public static boolean checkGender(String str){
        String regex = "^male|female|unknown$";
        String lowerCaseStr = str.toLowerCase();
        boolean check = lowerCaseStr.matches(regex);
        try {
            if (!check){
                throw new GenderException("Invalid gender. Only input Male | Female | Unknown");
            }
        } catch (GenderException e){
            System.out.println(e.getMessage());
        }
        return check;
    }

    public static boolean checkId(String str){
        String regex = "^[\\d]{3}[\\s]{1}[\\d]{3}[\\s]{1}[\\d]{3}$";
        boolean check = str.matches(regex);
        try {
            if (!check){
                throw new IdException("Invalid ID. Please input again (ID format: XXX XXX XXX)");
            }
        } catch (IdException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }

    public static boolean checkPhoneNumber(String str){
        String regex = "^[0]{1}[1-9]{1}[\\d]{8}$";
        boolean check = str.matches(regex);
        try {
            if (!check){
                throw new PhoneException("Invalid phone number. Please input again.");
            }
        } catch (PhoneException e){
            System.out.println(e.getMessage());
        }
        return check;
    }

    public static boolean checkEmail(String str) {
        String regex = "^[\\w\\d-_.]{3,20}@[\\w]{3,15}(.[\\w]{2,8}){1,3}$";
        boolean check = str.matches(regex);
        try {
            if (!check) {
                throw new EmailException("Invalid email. Please input again (Exp: abc@xyz.com)");
            }
        } catch (EmailException e){
            System.out.println(e.getMessage());
        }
        return check;
    }

    public static boolean checkCustomerClass(String str){
        String regex = "^Platinum|Gold|Silver|Member$";
        boolean check = str.matches(regex);
        try {
            if (!check){
                throw new CustomerClassException("Invalid class. Only input Platinum, Gold, Silver or Member");
            }
        } catch (CustomerClassException e){
            System.out.println(e.getMessage());
        }
        return check;
    }
}
