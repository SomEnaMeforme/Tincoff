package edu.hw5.Task4;

import java.util.regex.Pattern;

public class SafePasswordCheck {
    private SafePasswordCheck() {}

    public static boolean checkPassword(String password) {
        return password != null && Pattern.matches(".*[~!@#$%^&*|].*", password);
    }
}
