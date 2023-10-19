package edu.project1;

public class Data {
    public final char[] ENGLISH_ALPHABET = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
        'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public final String[] WORDS = new String[] {};
    public static final String HANGMAN_PICTURE = "\t\t\t  _______\n" +
        "\t\t\t  |/     |\n"
        +
        "\t\t\t  |     (_)\n"
        +
        "\t\t\t  |     _|_\n"
        +
        "\t\t\t  |    / | \\\n"
        +
        "\t\t\t  |      |\n"
        +
        "\t\t\t  |     / \\\n"
        +
        "\t\t\t  |    /   \\\n"
        +
        "\t\t\t  |\n"
        +
        "\t\t\t__|________\n"
        +
        "\t\t\t|         |";
    public static final String[] FAILS_PICTURES = new String[] {
        "\t\t\t__|________\n\t\t\t|         |",
        "\t\t\t  |/\n\t\t\t  |\n\t\t\t  |\n\t\t\t  |\n\t\t\t  |\n"
            +
            "\t\t\t  |\n\t\t\t  |\n\t\t\t  |\n\t\t\t__|________\n\t\t\t|         |",
        "\t\t\t  _______\n\t\t\t  |/     |\n\t\t\t  |\n\t\t\t  |\n\t\t\t  |\n\t\t\t  |\n"
            +
            "\t\t\t  |\n\t\t\t  |\n\t\t\t  |\n\t\t\t__|________\n\t\t\t|         |"

    };

}
