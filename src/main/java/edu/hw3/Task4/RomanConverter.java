package edu.hw3.Task4;

import java.util.Comparator;
import java.util.TreeMap;

public class RomanConverter {
    private RomanConverter() {
    }

    private static final int MAX_VALID_ARGUMENT = 3999;
    private static final int MIN_VALID_ARGUMENT = 1;
    @SuppressWarnings("checkstyle:MagicNumber")
    private static final TreeMap<Integer, String> REPLACEMENT_DICTIONARY = new TreeMap<>(Comparator.reverseOrder()) {{
        put(1, "I");
        put(4, "IV");
        put(5, "V");
        put(9, "IX");
        put(10, "X");
        put(40, "XL");
        put(50, "L");
        put(90, "XC");
        put(100, "C");
        put(400, "CD");
        put(500, "D");
        put(900, "CM");
        put(1000, "M");
    }};

    public static String convertToRoman(Integer number) {
        if (number < MIN_VALID_ARGUMENT || number > MAX_VALID_ARGUMENT) {
            return "Invalid input";
        }
        var variableNumber = number;
        var romanNumber = new StringBuilder();
        for (var kvp : REPLACEMENT_DICTIONARY.entrySet()) {
            var key = kvp.getKey();
            if (variableNumber / key > 0) {
                var iterationsCount = variableNumber / key;
                for (var i = 0; i < iterationsCount; i++) {
                    romanNumber.append(REPLACEMENT_DICTIONARY.get(key));
                }
                variableNumber %= key;
            }
        }
        return romanNumber.toString();
    }
}
