package exceptions;

public class IdException extends UserException {
    public IdException() {
    }

    public IdException(String message) {
        super(message);
    }

    public static boolean checkId(String str){
        String regex = "^[\\d]{3}[\\s]{1}[\\d]{3}[\\s]{1}[\\d]{3}$";
        boolean check = str.matches(regex);
        try {
            if (!check){
                throw new IdException("Invalid ID. Please input again (ID format: XXX XXX XXX");
            }
        } catch (IdException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }
}
