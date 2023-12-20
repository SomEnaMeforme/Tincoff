package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Pattern;

public class SlashDateParser extends CustomDateParser {
    public SlashDateParser(CustomDateParser next) {
        super(next);
    }

    private static final int CURRENT_CENTURY = 2000;
    private static final int PREVIOUS_CENTURY = 1900;

    @Override
    public Optional<LocalDate> parseDate(String string) {
        if (Pattern.matches("\\d{1,2}/\\d{1,2}/\\d{2,4}", string)) {
            var dateParts = string.split("/");
            var day = Integer.parseInt(dateParts[0]);
            var month = Integer.parseInt(dateParts[1]);
            var year = Integer.parseInt(dateParts[2]);
            if (Pattern.matches("\\d{1,2}/\\d{1,2}/\\d{2}", string)) {
                if (year > LocalDate.now().getYear()) {
                    year += PREVIOUS_CENTURY;
                } else {
                    year += CURRENT_CENTURY;
                }
            }
            return Optional.of(LocalDate.of(year, month, day));
        }
        return nextParser == null ? Optional.empty() : nextParser.parseDate(string);
    }
}
