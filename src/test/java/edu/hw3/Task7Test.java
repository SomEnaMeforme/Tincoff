package edu.hw3;

import edu.hw3.Task7.TreeWithNullComparator;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    public void isCorrectWorkWithNullArgument() {
        TreeMap<String, String> tree = new TreeMap<>(TreeWithNullComparator.getComparatorForNull());
        tree.put(null, "test");
        assertThat(tree.containsKey(null)).isTrue();
    }
    @Test
    public void isCorrectWorkWithNullArgument2() {
        TreeMap<String, String> tree = new TreeMap<>(TreeWithNullComparator.getComparatorForNull());
        tree.remove(null);
        assertThat(tree.containsKey(null)).isFalse();
    }
}
