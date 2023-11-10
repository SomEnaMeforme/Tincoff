package edu.hw3.Task3;

import java.util.Hashtable;

public class FrequencyDictionary {
    private FrequencyDictionary() {
    }

    public static <K> Hashtable<K, Integer> freqDict(K[] inputArray) {
        var result = new Hashtable<K, Integer>();
        for (var element : inputArray) {
            result.putIfAbsent(element, 0);
            result.put(element, result.get(element) + 1);
        }
        return result;
    }
}
