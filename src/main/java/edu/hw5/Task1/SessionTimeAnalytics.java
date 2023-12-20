package edu.hw5.Task1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

public class SessionTimeAnalytics {
    private SessionTimeAnalytics() {
    }

    private static final int MINUTES_IN_HOURS = 60;

    private static Duration getSumSessionDurationFromData(String[] data) {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
        Duration sumDuration = Duration.ZERO;
        for (String datum : data) {
            var datePair = datum.split(" - ");
            var date1 = LocalDateTime.parse(datePair[0], formatter);
            var date2 = LocalDateTime.parse(datePair[1], formatter);
            Duration sessionDuration = Duration.between(date1, date2);
            sumDuration = sumDuration.plus(sessionDuration);
        }
        return sumDuration;
    }

    private static Duration getAverageSessionTime(String[] data) {
        Duration sumDuration = getSumSessionDurationFromData(data);
        var average = Duration.ZERO;
        average = average.plusHours(sumDuration.toHours() / data.length);
        var minutesModFromAverageHours = ((sumDuration.toHours() % data.length) * MINUTES_IN_HOURS) / data.length;
        var minutesWithoutHours = (sumDuration.toMinutes() - sumDuration.toHours() * MINUTES_IN_HOURS) / data.length;
        average = average.plusMinutes(minutesModFromAverageHours + minutesWithoutHours);
        return average;
    }

    public static String getFormattedAverageSessionTime(String[] data) {
        if (data == null || Arrays.stream(data).anyMatch(Objects::isNull)) {
            return "0ч 0м";
        }
        var average = getAverageSessionTime(data);
        var minutes = average.toMinutes() - average.toHours() * MINUTES_IN_HOURS;
        return String.format("%sч %sм", average.toHours(), minutes);
    }
}
