package edu.hw7.Task2;

import java.util.stream.LongStream;

public class ParallelFactorial {
    private ParallelFactorial() {
    }

    public static long calculate(int number) {
        return LongStream
            .rangeClosed(1, number)
            .parallel()
            .reduce(1, (el1, el2) -> el1 * el2);
    }
}
