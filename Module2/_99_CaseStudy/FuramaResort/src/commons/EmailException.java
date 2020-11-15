package commons;

public class EmailException extends UserException {
    public EmailException() {
    }

    public EmailException(String message) {
        super(message);
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
}
