package edu.hw1.task7;

public class Task7 {
    public static int rotateRight(int n, int shift) {
        var binary = new StringBuilder(Integer.toBinaryString(n));
        return Integer.parseInt(shiftBinaryStr(binary, shift % binary.length()), 2);
    }

    public static int rotateLeft(int n, int shift) {
        var binary = new StringBuilder(Integer.toBinaryString(n));
        return Integer.parseInt(shiftBinaryStr(binary, binary.length() - shift % binary.length()), 2);
    }

    private static String shiftBinaryStr(StringBuilder binary, int shift) {
        var length = binary.length();
        var firstPart = binary.substring(length - shift);
        var secondPart = binary.substring(0, length - shift);
        return firstPart + secondPart;
    }

    private Task7() {
    }
}
