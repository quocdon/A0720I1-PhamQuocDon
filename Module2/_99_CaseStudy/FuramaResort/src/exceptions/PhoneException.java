package exceptions;

public class PhoneException extends UserException {
    public PhoneException() {
    }

    public PhoneException(String message) {
        super(message);
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
}
