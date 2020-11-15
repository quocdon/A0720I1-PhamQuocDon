package commons;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class BirthdayException extends UserException {
    public BirthdayException() {
    }

    public BirthdayException(String message) {
        super(message);
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
                if (year <= 1900){
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
    }
