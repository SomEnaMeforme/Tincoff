package edu.hw5.Task2;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class FridayTemporalAdjuster implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        var result = temporal;
        while (!(DayOfWeek.from(result) == DayOfWeek.FRIDAY
            && result.get(ChronoField.DAY_OF_MONTH) == AllScaryFridays.SCARY_FRIDAY_DATE)) {
            if (result.get(ChronoField.DAY_OF_MONTH) != AllScaryFridays.SCARY_FRIDAY_DATE) {
                result = result.plus(1, ChronoUnit.DAYS);
            } else {
                result = result.plus(1, ChronoUnit.MONTHS);
            }
        }
        return result;
    }
}
