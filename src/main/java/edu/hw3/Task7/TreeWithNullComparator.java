package edu.hw3.Task7;

import java.util.Comparator;

public class TreeWithNullComparator {
    private TreeWithNullComparator() {
    }

    public static <T extends Comparable> Comparator<T> getComparatorForNull() {
        return (o1, o2) -> {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }
            return o1.compareTo(o2);
        };
    }
}
