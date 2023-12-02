package edu.hw7.Task1;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private final int iterationsCount1 = 1000;
    private final int iterationsCount2 = 2000;
    private final int iterationsCount3 = 3000;

    public Counter() {
        value = new AtomicInteger();
        this.functions = new Runnable[] {
            () -> {
                for (var i = 0; i < iterationsCount1; i++) {
                    this.decrement();
                }
            },
            () -> {
                for (var i = 0; i < iterationsCount3; i++) {
                    this.increment();
                }
            },
            () -> {
                for (var i = 0; i < iterationsCount2; i++) {
                    this.decrement();
                }
            }
        };
    }

    public AtomicInteger value;
    private final Runnable[] functions;

    public void increment() {
        value.addAndGet(1);
    }

    public void decrement() {
        value.decrementAndGet();
    }

    public AtomicInteger startCount() {
        var threads = new ArrayList<Thread>();
        for (var func : functions) {
            threads.add(new Thread(func));
        }
        for (var thread : threads) {
            thread.start();
        }
        try {
            for (var thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this.value;
    }
}
