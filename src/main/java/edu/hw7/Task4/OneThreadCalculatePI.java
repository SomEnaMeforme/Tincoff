package edu.hw7.Task4;

import java.util.Random;

public class OneThreadCalculatePI {
    private int totalCount = 0;
    private int circleCount = 0;
    private final int width = 4000;
    private final int r = 2000;
    private final Random rnd = new Random();
    private final int multiplier = 4;

    public double calculate(int iterationsCount) {
        calculateDotCount(iterationsCount);
        return multiplier * (circleCount / (double) totalCount);
    }

    private void calculateDotCount(int iterationsCount) {
        for (var i = 0; i < iterationsCount; i++) {
            var dot = new Coordinate(rnd.nextInt(width), rnd.nextInt(width));
            if (dot.x() * dot.x() + dot.y() * dot.y() < r * r) {
                circleCount++;
            }
            totalCount++;
        }
    }
}
