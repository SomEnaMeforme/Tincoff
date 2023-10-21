package edu.hw2.Task4;

import java.util.Arrays;

public class Task4 {
    private Task4() {
    }

    public static CallingInfo callingInfo() {
        var stkTrace = new Throwable().getStackTrace();
        var info = Arrays.stream(stkTrace).skip(1).findFirst().get();
        return new CallingInfo(info.getClassName(), info.getMethodName());
    }
}
