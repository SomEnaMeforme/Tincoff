package edu.hw7.Task4;

import java.util.Random;

public class ThreadCalculate implements Runnable {
    private volatile CountForThread value;
    private volatile int iterationsCount;
    private final int width = 4000;
    private final int r = 2000;
    private final Random rnd = new Random();

    public ThreadCalculate(int iterCount) {
        this.iterationsCount = iterCount;
    }

    @Override
    public void run() {
        var localTotal = 0;
        var localCircle = 0;
        for (var i = 0; i < iterationsCount; i++) {
            var dot = new Coordinate(rnd.nextInt(width), rnd.nextInt(width));
            if (dot.x() * dot.x() + dot.y() * dot.y() < r * r) {
                localCircle++;
            }
            localTotal++;
        }
        value = new CountForThread(localCircle, localTotal);
    }

    public CountForThread getValue() {
        return value;
    }
}
