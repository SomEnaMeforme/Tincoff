package edu.hw3;

import org.junit.jupiter.api.Test;
import static edu.hw3.Task3.FrequencyDictionary.freqDict;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {
    @Test
    public void isWorkCorrectTest() {
        var result = freqDict(new String[] {"s", "dd", "s", "dd"});
        assertThat(result.get("s")).isEqualTo(2);
        assertThat(result.get("dd")).isEqualTo(2);
    }
    @Test
    public void isWorkCorrectWithIntegerTest() {
        var result = freqDict(new Integer[] {1, 1, 2, 2});
        assertThat(result.get(1)).isEqualTo(2);
        assertThat(result.get(2)).isEqualTo(2);
    }
    @Test
    public void isWorkCorrectWithWordTest() {
        var result = freqDict(new String[] {"this", "and", "that", "and"});
        assertThat(result.get("and")).isEqualTo(2);
        assertThat(result.get("this")).isEqualTo(1);
        assertThat(result.get("that")).isEqualTo(1);
    }
    @Test
    public void isWorkCorrectWithWordInRusTest() {
        var result = freqDict(new String[] {"кот", "and", "кот", "кот"});
        assertThat(result.get("and")).isEqualTo(1);
        assertThat(result.get("кот")).isEqualTo(3);
    }
    @Test
    public void isFailsWhenArgsIsNull() {
        assertThrows(NullPointerException.class, () -> freqDict(null));
    }
    @Test
    public void returnEmptyDictWhenArgsEmpty() {
        var result = freqDict(new String[] {});
        assertThat(result.isEmpty()).isTrue();
    }
}
