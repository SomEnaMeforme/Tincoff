package edu.hw1.task0_task1;

public class Task1 {
    private Task1() {}

    private static final int COUNT_SECONDS_IN_MINUTES = 60;

    public static int minutesToSeconds(String time) {
        var parseData = time.split(":");
        if (!isInputContainsOnlyOneColon(parseData)) {
            return 1;
        }
        int minutes;
        int seconds;
        try {
            minutes = Integer.parseInt(parseData[0]);
            seconds = Integer.parseInt(parseData[1]);
        } catch (NumberFormatException e) {
            return 1;
        }
        if (!secondsIsValid(seconds) || minutes < 0) {
            return 1;
        }
        return minutes * COUNT_SECONDS_IN_MINUTES + seconds;
    }

    private static Boolean secondsIsValid(int seconds) {
        return seconds < COUNT_SECONDS_IN_MINUTES && seconds >= 0;
    }

    private static Boolean isInputContainsOnlyOneColon(String[] parseData) {
        return parseData.length == 2;
    }
}
