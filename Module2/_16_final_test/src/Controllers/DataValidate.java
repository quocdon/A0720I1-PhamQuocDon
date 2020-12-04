package Controllers;

import Models.Customer;
import Models.Deposit;

import java.time.LocalDate;
import java.util.List;

public class DataValidate {
    private static String regex = "";

    public static boolean checkDepositId(String str) {
        regex = "^STK-[\\d]{4}$";
        return str.matches(regex);
    }

    public static boolean checkDuplicate(String str, List<Deposit> list) {
        for (Deposit deposit : list) {
            if (deposit.getDepositId().equals(str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkCustomerId(String str, List<Customer> list) {
        for (Customer customer : list) {
            if (customer.getCustomerId().equals(str)) {
                return true;
            }

        }
        return false;
    }

    public static boolean checkDate(String str) {
        regex = "^[\\d]{2}\\/[\\d]{2}\\/[\\d]{4}$";
        boolean check = str.matches(regex);
        if (check) {
            int day = Integer.parseInt(str.substring(0, 2));
            int month = Integer.parseInt(str.substring(3, 5));
            int year = Integer.parseInt(str.substring(6, 10));
            LocalDate birthday;
            try {
                birthday = LocalDate.of(year, month, day);
            } catch (Exception e) {
                return false;
            }
        }
        return check;
    }

    public static boolean checkAmount(String str){
        double amount;
        try{
            amount  = Double.parseDouble(str);
            if (amount > 1000000){
                return true;
            }
            return false;
        } catch (Exception e){
            return false;
        }
    }


}
