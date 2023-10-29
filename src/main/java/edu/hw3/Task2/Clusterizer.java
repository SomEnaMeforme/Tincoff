package edu.hw3.Task2;

import java.util.ArrayList;
import java.util.Stack;

public class Clusterizer {
    private Clusterizer() {
    }

    public static ArrayList<String> clusterize(String input) {
        var result = new ArrayList<String>();
        var stack = new Stack<Character>();
        var currentStr = new StringBuilder();
        for (var symbol : input.toCharArray()) {
            if (symbol == '(') {
                stack.push(symbol);
            } else if (symbol == ')') {
                stack.pop();
                if (stack.empty()) {
                    currentStr.append(symbol);
                    result.add(currentStr.toString());
                    currentStr = new StringBuilder();
                    continue;
                }
            } else {
                return null;
            }
            currentStr.append(symbol);
        }
        return stack.empty() ? result : null;
    }
}
