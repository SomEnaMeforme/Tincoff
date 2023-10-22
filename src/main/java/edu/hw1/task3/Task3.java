package edu.hw1.task3;

import java.util.Arrays;

public class Task3 {
    public static boolean isNestable(int[] first, int[] second) throws NullPointerException {
        if (first == null || second == null) {
            throw new NullPointerException();
        }
        if (isNotEmpty(first) && isNotEmpty(second)) {
            return getMin(first) > getMin(second) && getMax(first) < getMax(second);
        }
        return false;
    }

    private static boolean isNotEmpty(int[] arr) {
        return arr.length > 0;
    }

    private static int getMin(int[] array) {
        return Arrays.stream(array).min().getAsInt();
    }

    private static int getMax(int[] array) {
        return Arrays.stream(array).max().getAsInt();
    }

    private Task3() {
    }
}
