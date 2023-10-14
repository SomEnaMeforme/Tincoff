package edu.hw1.task0_task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task0 {
    private final static Logger LOGGER = LogManager.getLogger();

    public static void execute() {

        LOGGER.info("Привет, мир!");
    }

    private Task0() {

    }
}
