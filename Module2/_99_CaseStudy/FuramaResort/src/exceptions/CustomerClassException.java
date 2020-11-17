package exceptions;

public class CustomerClassException extends UserException {
    public CustomerClassException() {
    }

    public CustomerClassException(String message) {
        super(message);
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
