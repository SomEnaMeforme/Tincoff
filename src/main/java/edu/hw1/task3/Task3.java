package edu.hw1.task3;

import java.util.Arrays;

public class Task3 {
    public static boolean isNestable(int[] first, int[] second) throws NullPointerException {
        if (first == null || second == null) {
            throw new NullPointerException();
        }
        if (!isEmpty(first) && !isEmpty(second)) {
            return Arrays.stream(first).min().getAsInt() > Arrays.stream(second).min().getAsInt()
                && Arrays.stream(first).max().getAsInt() < Arrays.stream(second).max().getAsInt();
        }
        return isEmpty(first);
    }

    private static boolean isEmpty(int[] arr) {
        return arr.length == 0;
    }

    private Task3() {
    }
}
