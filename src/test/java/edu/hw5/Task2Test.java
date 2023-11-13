package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static edu.hw5.Task2.AllScaryFridays.allFridaysFallingOn13thInYear;
import edu.hw5.Task2.FridayTemporalAdjuster;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test  {
    @Test
    public void isCorrectWorkSimpleTest() {
        assertThat(allFridaysFallingOn13thInYear(1925).toArray()).isEqualTo(new LocalDate[] {
            LocalDate.of(1925, 2, 13),
            LocalDate.of(1925, 3, 13),
            LocalDate.of(1925, 11, 13),
        });
    }
    @Test
    public void isCorrectWorkWithFutureYearTest() {
        assertThat(allFridaysFallingOn13thInYear(2024).toArray()).isEqualTo(new LocalDate[] {
            LocalDate.of(2024, 9, 13),
            LocalDate.of(2024, 12, 13)
        });
    }
    @Test
    public void isCorrectWorkWithNegativeYearTest() {
        assertThat(allFridaysFallingOn13thInYear(-1).toArray()).isEqualTo(new LocalDate[0]);
    }
    @Test
    public void isCorrectWorkAdjusterTest() {
        var date = LocalDate.of(1925, 3, 12);
        assertThat(date.with(new FridayTemporalAdjuster())).isEqualTo(LocalDate.of(1925, 3, 13));
    }
    @Test
    public void isCorrectWorkAdjusterWhenDateIsFridayTest() {
        var date = LocalDate.of(1925, 3, 6);
        assertThat(date.with(new FridayTemporalAdjuster())).isEqualTo(LocalDate.of(1925, 3, 13));
    }
    @Test
    public void isCorrectWorkAdjusterWhenDateIsFriday13thTest() {
        var date = LocalDate.of(1925, 3, 13);
        assertThat(date.with(new FridayTemporalAdjuster())).isEqualTo(LocalDate.of(1925, 3, 13));
    }
    @Test
    public void isCorrectWorkAdjusterWhenDaysMoreThan13Test() {
        var date =  LocalDate.of(1925, 2, 21);
        assertThat(date.with(new FridayTemporalAdjuster())).isEqualTo(LocalDate.of(1925, 3, 13));
    }
    @Test
    public void isCorrectWorkAdjusterWhenFriday13thInNextYearTest() {
        var date = LocalDate.of(2024, 12, 14);
        assertThat(date.with(new FridayTemporalAdjuster())).isEqualTo(LocalDate.of(2025, 6, 13));
    }

}
