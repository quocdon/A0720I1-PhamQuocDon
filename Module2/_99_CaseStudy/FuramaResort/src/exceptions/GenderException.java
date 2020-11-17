package exceptions;

public class GenderException extends UserException {
    public GenderException() {
    }

    public GenderException(String message) {
        super(message);
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
}
