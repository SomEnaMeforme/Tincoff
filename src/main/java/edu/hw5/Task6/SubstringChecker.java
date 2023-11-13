package edu.hw5.Task6;

import java.util.regex.Pattern;

public class SubstringChecker {
    private SubstringChecker() {
    }

    public static boolean isSubstring(String string, String substring) {
        var validSub = Pattern.quote(substring);
        var regex = ".*" + validSub + ".*";
        return string != null && Pattern.matches(regex, string);
    }
}
