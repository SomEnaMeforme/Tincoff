package edu.hw3;

import edu.hw3.Task8.BackwardIterator;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.NoSuchElementException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task8Test {
    @Test
    public void isWorkCorrect() {
        var iter = new BackwardIterator<>(List.of(1,2,3));
        assertThat(iter.next()).isEqualTo(3);
        assertThat(iter.next()).isEqualTo(2);
        assertThat(iter.next()).isEqualTo(1);
    }
    @Test
    public void isWorkCorrectWithString() {
        var iter = new BackwardIterator<>(List.of("1,2,3", "g", "dfjgh"));
        assertThat(iter.next()).isEqualTo("dfjgh");
        assertThat(iter.next()).isEqualTo("g");
        assertThat(iter.next()).isEqualTo("1,2,3");
    }
    @Test
    public void isWorkCorrectWithEmptyList() {
        var iter = new BackwardIterator<>(List.of());
        assertThrows(NoSuchElementException.class, () -> iter.next());
    }
}
