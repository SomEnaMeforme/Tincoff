package edu.hw7;

import edu.hw7.Task2.ParallelFactorial;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    public void isCorrectWork() {
        assertThat(ParallelFactorial.calculate(6)).isEqualTo(720);
    }
    @Test
    public void isCorrectWork2() {
        var first = ParallelFactorial.calculate(10);
        var second = ParallelFactorial.calculate(10);
        assertThat(first).isEqualTo(3628800);
        assertThat(second).isEqualTo(3628800);
    }
    @Test //интереса ради
    public void parallelNotFaster() {
        long startTime = System.currentTimeMillis();
        var first = ParallelFactorial.calculate(25);
        long endTime = System.currentTimeMillis();
        long timeParallel = endTime - startTime;


        var startTime2 = System.currentTimeMillis();
        var second = 1L;
        for (var i = 1; i <= 25; i++) {
            second *= i;
        }
        var endTime2 = System.currentTimeMillis();
        long timesSequentially = endTime2 - startTime2;
        assertThat(timeParallel < timesSequentially).isFalse();
    }
}
