package edu.hw7.Task4;

public class ManyThreadCalculatePI {
    private int totalCount = 0;
    private int circleCount = 0;
    private final int multiplier = 4;

    private final int threadsCount = 8;

    public int calculate(int iterationsCount) {
        calculateWithThreads(iterationsCount);
        return multiplier * (circleCount / totalCount);
    }

    private void calculateWithThreads(int iterationsCount) {
        var threads = new Thread[threadsCount];
        var results = new ThreadCalculate[threadsCount];
        for (var thrNum = 0; thrNum < threadsCount - 1; thrNum++) {
            var tmp = new ThreadCalculate(iterationsCount / threadsCount);
            var thread = new Thread(tmp);
            threads[thrNum] = thread;
            thread.start();
            results[thrNum] = tmp;
        }
        var tmp = new ThreadCalculate(iterationsCount / threadsCount + iterationsCount % threadsCount);
        var thread = new Thread(tmp);
        thread.start();
        threads[threadsCount - 1] = thread;
        results[threadsCount - 1] = tmp;
        for (var thr : threads) {
            try {
                thr.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (var res : results) {
            totalCount += res.getValue().totalCount();
            circleCount += res.getValue().circleCount();
        }
    }
}

