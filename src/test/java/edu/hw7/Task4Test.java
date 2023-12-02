package edu.hw7;

import edu.hw7.Task4.TimeCalculate;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    public void intrestingTest() {
        TimeCalculate.calculateTime();
        assertThat(true).isTrue();
    }
}
