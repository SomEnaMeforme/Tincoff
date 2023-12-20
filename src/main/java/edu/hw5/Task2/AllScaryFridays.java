package edu.hw5.Task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class AllScaryFridays {
    private AllScaryFridays() {
    }

    protected final static int SCARY_FRIDAY_DATE = 13;

    public static ArrayList<LocalDate> allFridaysFallingOn13thInYear(int year) {
        if (invalidYear(year)) {
            return new ArrayList<>();
        }
        var firstDate = LocalDate.of(year, 1, SCARY_FRIDAY_DATE);
        var result = new ArrayList<LocalDate>();
        while (firstDate.getYear() == year) {
            if (firstDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
                result.add(firstDate);
            }
            firstDate = firstDate.plusMonths(1);
        }
        return result;
    }

    private static boolean invalidYear(int year) {
        return year < 0;
    }
}
