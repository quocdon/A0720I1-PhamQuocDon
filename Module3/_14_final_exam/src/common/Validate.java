package common;

public class Validate {
    private static String regex;

    public static boolean checkName(String name){
        regex = "^[a-zA-Z\\s]{5,50}$";
        return name.matches(regex);
    }

    public static boolean checkPhone(String phone){
        regex = "^[0-9]{10}$";
        return phone.matches(regex);
    }

//    public static boolean checkRemark(String remark){
//
//    }
}
