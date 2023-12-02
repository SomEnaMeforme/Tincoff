package edu.hw7.Task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TimeCalculate {
    private TimeCalculate() {
    }

    private final static Logger LOGGER = LogManager.getLogger();
    private final static int TEN_MILLION = 10000000;
    private final static int HUNDRED_MILLION = 100000000;
    private final static int BILLION = 1000000000;
    private final static String RESULT_TIME_FORMAT = "Result time: %d";
    private final static String RESULT_APPROXIMATION_FORMAT = "Result approximation for iterations count = %d : %e";

    public static void calculateTime() {
        calculateOneTime(TEN_MILLION);
        calculateManyTime(TEN_MILLION);
        calculateOneTime(HUNDRED_MILLION);
        calculateManyTime(HUNDRED_MILLION);
        calculateOneTime(BILLION);
        calculateManyTime(BILLION);
    }

    private static void calculateOneTime(int iterationsCount) {
        var one = new OneThreadCalculatePI();
        long startTime = System.currentTimeMillis();
        var result = one.calculate(iterationsCount);
        long endTime = System.currentTimeMillis();
        LOGGER.info(String.format(RESULT_TIME_FORMAT, endTime - startTime));
        LOGGER.info(String.format(
            RESULT_APPROXIMATION_FORMAT,
            iterationsCount,
            result - Math.PI
        ));

    }

    private static void calculateManyTime(int iterationsCount) {
        var many = new ManyThreadCalculatePI();
        long startTime = System.currentTimeMillis();
        var result = many.calculate(iterationsCount);
        long endTime = System.currentTimeMillis();
        LOGGER.info(String.format(RESULT_TIME_FORMAT, endTime - startTime));
        LOGGER.info(String.format(
            RESULT_APPROXIMATION_FORMAT,
            iterationsCount,
            result - Math.PI
        ));
    }
}
