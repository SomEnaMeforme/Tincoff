package edu.hw1.task2;

public class Task2 {

    private static final int FIRST_NUMBER_WITH_TWO_DIGITS = 10;

    public static int getCountDigits(int number) {
        var countDigits = 1;
        var variableAbsNumber = Math.abs(number);
        while (numberHasMoreThanOneDigit(variableAbsNumber)) {
            countDigits++;
            variableAbsNumber /=  FIRST_NUMBER_WITH_TWO_DIGITS;
        }
        return countDigits;
    }

    private static boolean numberHasMoreThanOneDigit(int number) {
        return number / FIRST_NUMBER_WITH_TWO_DIGITS > 0;
    }

    private Task2() {
    }

}
