package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.Pattern;

public class HyphenDateParser extends CustomDateParser {
    public HyphenDateParser(CustomDateParser next) {
        super(next);
    }

    @Override
    public Optional<LocalDate> parseDate(String string) {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (Pattern.matches("\\d{4}-\\d{2}-\\d{2}", string)) {
            var date = LocalDate.parse(string, formatter);
            return Optional.of(date);
        }
        if (Pattern.matches("\\d{4}-\\d{2}-\\d", string)) {
            var validString = string.substring(0, string.length() - 1) + "0" + string.substring(string.length() - 1);
            var date = LocalDate.parse(validString, formatter);
            return Optional.of(date);
        }

        return nextParser == null ? Optional.empty() : nextParser.parseDate(string);
    }
}

