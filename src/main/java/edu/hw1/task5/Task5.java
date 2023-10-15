package edu.hw1.task5;

public class Task5 {
    private Task5() {
    }

    private static final int LAST_TWO_DIGIT_NUMBER = 99;
    private static final int LAST_ONE_DIGIT_NUMBER = 9;
    private static final int FIRST_NUMBER_WITH_TWO_DIGITS = 10;

    public static boolean isPalindromeDescendant(int number) {
        if (!numberHasDescendants(number)) {
            return isPalindrome(Integer.toString(number));
        }
        return isPalindromeDescendant(getDescendant(number));
    }

    private static boolean numberHasDescendants(Integer number) {
        return (numberHasMoreThanTwoDigits(number)
            || numberHasTwoDigits(number) && numberHasTwoDigits(sumDigitsTwoDigitsNumber(number)))
            && numberHasEvenDigitsCount(number);
    }

    private static boolean numberHasEvenDigitsCount(Integer number) {
        return number.toString().length() % 2 == 0;
    }

    private static boolean numberHasMoreThanTwoDigits(int number) {
        return number > LAST_TWO_DIGIT_NUMBER;
    }

    private static boolean numberHasTwoDigits(int number) {
        return number < LAST_TWO_DIGIT_NUMBER && number > LAST_ONE_DIGIT_NUMBER;
    }

    private static int sumDigitsTwoDigitsNumber(int number) {
        return number % FIRST_NUMBER_WITH_TWO_DIGITS + number / FIRST_NUMBER_WITH_TWO_DIGITS;
    }

    private static int getDescendant(int number) {
        var tmpStr = Integer.toString(number);
        var newNumb = new StringBuilder();
        for (var i = 0; i < tmpStr.length(); i += 2) {
            newNumb.append(
                Character.getNumericValue(tmpStr.charAt(i)) + Character.getNumericValue(tmpStr.charAt(i + 1))
            );
        }
        return Integer.parseInt(newNumb.toString());
    }

    private static boolean isPalindrome(String text) {
        var isPalindrom = true;
        for (var ind = 0; ind < text.length() / 2; ind++) {
            isPalindrom = isPalindrom && text.charAt(ind) == text.charAt(text.length() - ind - 1);
        }
        return text.length() > 1 && isPalindrom;
    }
}
