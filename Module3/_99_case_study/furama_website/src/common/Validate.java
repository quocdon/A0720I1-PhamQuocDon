package common;

import model.User;

import java.util.List;

public class Validate {
    private String regex;

    public Validate() {
    }

    public Validate(String regex) {
        this.regex = regex;
    }

    public boolean checkRegex(String string) {
        return string.matches(regex);
    }

    public boolean checkNumber(String string) {
        try {
            return Double.parseDouble(string) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isExist(String username, List<User> userList) {
        for (User user : userList) {
            if (user.getUsername().equals(username)){
                return false;
            }
        }
        return true;
    }
}
