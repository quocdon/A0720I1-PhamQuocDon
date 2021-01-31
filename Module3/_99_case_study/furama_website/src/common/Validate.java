package common;

public class Validate {
    private String regex;

    public Validate(String regex) {
        this.regex = regex;
    }

    public boolean checkRegex(String string){
        return string.matches(regex);
    }
}
