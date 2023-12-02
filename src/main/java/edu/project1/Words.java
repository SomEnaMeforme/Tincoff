package edu.project1;

import java.util.Random;

public class Words {
    private Words() {
    }

    private static final String[] DICTIONARY = new String[] {
        "database",
        "namespace",
        "validation",
        "programming",
        "variable"};

    public static String getRandomWord() {
        var rndIndex = new Random().nextInt(DICTIONARY.length);
        return DICTIONARY[rndIndex];
    }

    //для проверки корректности словаря в тестах
    public static String[] getDictionary() {
        return DICTIONARY;
    }
}
