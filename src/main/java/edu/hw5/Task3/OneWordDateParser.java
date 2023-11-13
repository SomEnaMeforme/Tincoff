package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Pattern;

public class OneWordDateParser extends CustomDateParser {

    public OneWordDateParser(CustomDateParser next) {
        super(next);
    }

    @Override
    public Optional<LocalDate> parseDate(String string) {
        if (Pattern.matches("\\w+", string)) {
            return
                switch (string) {
                    case "today" -> Optional.of(LocalDate.now());
                    case "yesterday" -> Optional.of(LocalDate.now().minusDays(1));
                    case "tomorrow" -> Optional.of(LocalDate.now().plusDays(1));
                    default -> Optional.empty();
                };
        }
        return nextParser == null ? Optional.empty() : nextParser.parseDate(string);
    }
}
