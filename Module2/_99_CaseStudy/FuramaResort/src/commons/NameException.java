package commons;

public class NameException extends UserException {

    public NameException(String name) {
        super(name);
    }

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
}
