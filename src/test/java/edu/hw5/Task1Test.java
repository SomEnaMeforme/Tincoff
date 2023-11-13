package edu.hw5;

import static edu.hw5.Task1.SessionTimeAnalytics.getFormattedAverageSessionTime;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task1Test {
    @Test
    public void isCorrectWorkSimpleTest() {
        var data = new String[] {
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 19:30 - 2022-04-01, 23:20"
        };
        assertThat(getFormattedAverageSessionTime(data)).isEqualTo("3ч 40м");
    }
    @Test
    public void isCorrectWorkWithDifferentDays() {
        var data = new String[] {
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"
        };
        assertThat(getFormattedAverageSessionTime(data)).isEqualTo("3ч 40м");
    }
    @Test
    public void isCorrectWorkWhenSumDurationMoreThanDay() {
        var data = new String[] {
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20",
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-05, 21:30 - 2022-04-06, 01:20",
            "2022-03-21, 20:20 - 2022-03-21, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20",
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20",
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 19:30 - 2022-04-01, 23:20"
        };
        assertThat(getFormattedAverageSessionTime(data)).isEqualTo("3ч 40м");
    }
    @Test
    public void isCorrectWorkWithNullDataElements() {
        var data = new String[] {
            null,
            null
        };
        assertThat(getFormattedAverageSessionTime(data)).isEqualTo("0ч 0м");
    }
    @Test
    public void isCorrectWorkWithNullData() {
        var data = new String[] {
            null,
            null
        };
        assertThat(getFormattedAverageSessionTime(data)).isEqualTo("0ч 0м");
    }
    @Test
    public void isCorrectWorkWhenDataHasSingleElement() {
        var data = new String[] {
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
        };
        assertThat(getFormattedAverageSessionTime(data)).isEqualTo("3ч 30м");
    }
}
