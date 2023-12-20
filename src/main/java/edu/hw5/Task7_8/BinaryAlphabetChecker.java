package edu.hw5.Task7_8;

import java.util.regex.Pattern;

public class BinaryAlphabetChecker {
    private BinaryAlphabetChecker() {
    }

    private static final String CONTAINS_ONLY_ONE_AND_ZERO = "[10]+";

    public static boolean checkMessageContainsAtLeastThreeSymbolAndThirdIsZero(String message) {
        return message != null && Pattern.matches("[10]{2}0[10]*", message);
    }

    public static boolean checkMessageStartEqualToEnd(String message) {
        return message != null && (Pattern.matches("1[10]*1$", message)
            || Pattern.matches("0[10]*0$", message)
            || message.equals("1") || message.equals("0"));
    }

    public static boolean checkMessageLengthAtLeastOneNoMoreThanThree(String message) {
        return message != null && Pattern.matches("[10]{1,3}", message);
    }

    public static boolean checkMessageHasOddLength(String message) {
        return message != null && Pattern.matches("[10]([10][10])*$", message);
    }

    public static boolean checkMessageNoConsecutiveOne(String message) {
        return message != null && !Pattern.matches(".*1{2,}.*", message)
            && Pattern.matches(CONTAINS_ONLY_ONE_AND_ZERO, message);
    }

    public static boolean checkMessageNoConsecutiveOneTwoOrThreeTime(String message) {
        return message != null && !Pattern.matches("1{2,3}", message)
            && Pattern.matches(CONTAINS_ONLY_ONE_AND_ZERO, message);
    }

    public static boolean checkMessageEveryOddSymbolIsOne(String message) {
        return message != null && Pattern.matches("(1[10])\\1?1?", message);
    }

    public static boolean checkMessageContainsAtLeastTwoZeroAndOnceOne(String message) {
        return message != null && Pattern.matches("(0+1?0+|10{2,}|0{2,}1)", message);
    }
}
