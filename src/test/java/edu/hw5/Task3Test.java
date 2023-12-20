package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import edu.hw5.Task3.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task3Test {
    private static final CustomDateParser dateParser = new SlashDateParser(
        new HyphenDateParser(
            new OneWordDateParser(
                new DaysAgoDateParser(null)))
    );
    @Test
    public void isCorrectWorkDateParser() {
        assertThat(dateParser.parseDate("2020-10-10").get()).isEqualTo(LocalDate.of(2020, 10, 10));
    }
    @Test
    public void isCorrectWorkForOneDigitForDay() {
        assertThat(dateParser.parseDate("2020-10-1").get()).isEqualTo(LocalDate.of(2020, 10, 1));
    }
    @Test
    public void isCorrectWorkForSlashSeparator() {
        assertThat(dateParser.parseDate("1/3/1976").get()).isEqualTo(LocalDate.of(1976, 3, 1));
    }
    @Test
    public void isCorrectWorkForSlashSeparatorWithZeros() {
        assertThat(dateParser.parseDate("01/03/1976").get()).isEqualTo(LocalDate.of(1976, 3, 1));
    }
    @Test
    public void isCorrectWorkForSlashSeparatorShortYear() {
        assertThat(dateParser.parseDate("1/3/20").get()).isEqualTo(LocalDate.of(2020, 3, 1));
    }
    @Test
    public void isCorrectWorkForWordDateToday() {
        assertThat(dateParser.parseDate("today").get()).isEqualTo(LocalDate.of(2023, 11, 13));
    }
    @Test
    public void isCorrectWorkForWordDateYesterday() {
        assertThat(dateParser.parseDate("yesterday").get()).isEqualTo(LocalDate.of(2023, 11, 12));
    }
    @Test
    public void isCorrectWorkForWordDateTomorrow() {
        assertThat(dateParser.parseDate("tomorrow").get()).isEqualTo(LocalDate.of(2023, 11, 14));
    }
    @Test
    public void isCorrectWorkOneDayAgo() {
        assertThat(dateParser.parseDate("1 day ago").get()).isEqualTo(LocalDate.of(2023, 11, 12));
    }
    @Test
    public void isCorrectWorkManyDaysAgo() {
        assertThat(dateParser.parseDate("2234 days ago").get()).isEqualTo(LocalDate.of(2017, 10, 1));
    }
    @Test
    public void isCorrectWorkNobodyCanParse() {
        assertThat(dateParser.parseDate("32480985")).isEqualTo(Optional.empty());
    }
}
