package edu.hw3.Task1;

import java.util.Hashtable;
import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;

public class Atbash {
    private Atbash() {
    }

    private static final Hashtable<Character, Character> REPLACEMENT_MAP = preprocessing();

    private static Hashtable<Character, Character> preprocessing() {
        var alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        var result = new Hashtable<Character, Character>();
        for (var i = 0; i < alphabet.length; i++) {
            result.put(alphabet[i], alphabet[alphabet.length - i - 1]);
        }
        return result;

    }

    public static String atbash(String text) throws NullPointerException {
        if (text == null) {
            throw new NullPointerException("Invalid input");
        }
        var encryptedText = new StringBuilder();
        for (Character symbol : text.toCharArray()) {
            if (REPLACEMENT_MAP.containsKey(symbol)) {
                encryptedText.append(REPLACEMENT_MAP.get(symbol));
            } else if (REPLACEMENT_MAP.containsKey(toLowerCase(symbol))) {
                encryptedText.append(toUpperCase(REPLACEMENT_MAP.get(toLowerCase(symbol))));
            } else {
                encryptedText.append(symbol);
            }
        }
        return encryptedText.toString();
    }
}
