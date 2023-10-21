package edu.project1;

import java.util.Random;

public class Words {
    public static final String[] dictionary = new String[] {
        "database",
        "namespace",
        "validation",
        "debug",
        "variable"};

    public static String getRandomWord() {
        var rndIndex = new Random().nextInt(dictionary.length);
        return dictionary[rndIndex];
    }
}
