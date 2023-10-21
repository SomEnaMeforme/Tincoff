package edu.hw1.task4;

public class Task4 {
    private Task4() {
    }

    public static String fixString(String brokenStr) {
        var fixedStr = new StringBuilder();
        if (brokenStr == null) {
            throw new NullPointerException();
        }
        var maxIndex = getMaxIndex(brokenStr.length());
        for (var i = 0; i < maxIndex; i++) {
            fixedStr.insert(i, brokenStr.charAt(getOldIndexForNewPosition(i)));
        }
        if (maxIndex < brokenStr.length()) {
            fixedStr.append(brokenStr.charAt(maxIndex));
        }
        return fixedStr.toString();
    }

    private static int getOldIndexForNewPosition(int newPosition) {
        return newPosition % 2 == 1 ? newPosition - 1 : newPosition + 1;
    }

    private static int getMaxIndex(int strLength) {
        return strLength % 2 == 1 ? strLength - 1 : strLength;
    }
}
