package edu.hw3.Task1;

import java.util.Hashtable;
import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;

public class Atbash {
    private Atbash() {
    }

    private static Hashtable<Character, Character> replacementMap;
    private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    private static Hashtable<Character, Character> preprocessing() {
        var result = new Hashtable<Character, Character>();
        for (var i = 0; i < ALPHABET.length; i++) {
            result.put(ALPHABET[i], ALPHABET[ALPHABET.length - i - 1]);
        }
        return result;

    }

    public static String atbash(String text) throws NullPointerException {
        replacementMap = replacementMap != null ? replacementMap : preprocessing();
        if (text == null) {
            throw new NullPointerException("Invalid input");
        }
        var encryptedText = new StringBuilder();
        for (Character symbol : text.toCharArray()) {
            if (replacementMap.containsKey(symbol)) {
                encryptedText.append(replacementMap.get(symbol));
            } else if (replacementMap.containsKey(toLowerCase(symbol))) {
                encryptedText.append(toUpperCase(replacementMap.get(toLowerCase(symbol))));
            } else {
                encryptedText.append(symbol);
            }
        }
        return encryptedText.toString();
    }
}
