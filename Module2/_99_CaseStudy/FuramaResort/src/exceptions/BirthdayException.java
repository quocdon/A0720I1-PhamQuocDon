package exceptions;

import java.time.LocalDate;
import java.time.Period;

public class BirthdayException extends UserException {
    public BirthdayException() {
    }

    public BirthdayException(String message) {
        super(message);
    }

}
