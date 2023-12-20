package edu.hw5.Task5;

import java.util.regex.Pattern;

public class RussianRegistrationPlates {
    private RussianRegistrationPlates() {}

    public static boolean checkPlate(String plate) {
        return plate != null && Pattern.matches("[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d{3}", plate);
    }
}
