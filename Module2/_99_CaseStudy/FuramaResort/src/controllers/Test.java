package controllers;

public class Test {
    public static boolean check(String str){
        String regex = "^[A-Z][a-z]{0,}([\\s]{1}[A-Z][a-z]{0,})*$";
        return str.matches(regex);
    }
    public static void main(String[] args) {
        System.out.println(check("Nguyen"));
    }
}
