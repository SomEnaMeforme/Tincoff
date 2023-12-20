package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public abstract class CustomDateParser {
    public CustomDateParser nextParser;

    public CustomDateParser(CustomDateParser next) {
        nextParser = next;
    }

    public abstract Optional<LocalDate> parseDate(String string);
}
