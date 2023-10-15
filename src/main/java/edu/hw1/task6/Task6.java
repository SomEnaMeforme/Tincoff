package edu.hw1.task6;

import static java.util.Arrays.sort;

public class Task6 {
    private Task6() {
    }

    private static final int FIRST_NUMBER_WITH_TWO_DIGITS = 10;
    private static final int FIRST_NUMBER_WITH_FOUR_DIGITS = 1000;
    private static final int LAST_NUMBER_WITH_FOUR_DIGITS = 9999;

    private static final int KAPREKAR_CONSTANT = 6174;

    public static int countK(int number) throws IllegalArgumentException {
        if (!isFourDigitNumberNotEqualsThousand(number) || allDigitsSameInFourDigitsNumber(number)) {
            throw new IllegalArgumentException();
        }
        return countK(number, 0);
    }

    private static int countK(int number, int stepCount) {
        if (number == KAPREKAR_CONSTANT) {
            return stepCount;
        }
        var digits = Integer.toString(number).toCharArray();
        sort(digits);
        var sortedDigits = new String(digits);
        var min = Integer.parseInt(sortedDigits);
        var max = Integer.parseInt(new StringBuilder(sortedDigits).reverse().toString());
        return countK(max - min, stepCount + 1);
    }

    private static boolean allDigitsSameInFourDigitsNumber(int number) {
        var lastDigit = number % FIRST_NUMBER_WITH_TWO_DIGITS;
        var numderWithSameDigits = lastDigit;
        for (var multiplier = FIRST_NUMBER_WITH_TWO_DIGITS; multiplier <= FIRST_NUMBER_WITH_FOUR_DIGITS;
             multiplier *= FIRST_NUMBER_WITH_TWO_DIGITS) {
            numderWithSameDigits += multiplier * lastDigit;
        }
        return number == numderWithSameDigits;
    }

    private static boolean isFourDigitNumberNotEqualsThousand(int number) {
        return number > FIRST_NUMBER_WITH_FOUR_DIGITS && number <= LAST_NUMBER_WITH_FOUR_DIGITS;
    }
}
