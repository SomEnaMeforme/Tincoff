package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Pattern;

public class DaysAgoDateParser extends CustomDateParser {
    public DaysAgoDateParser(CustomDateParser next) {
        super(next);
    }

    @Override
    public Optional<LocalDate> parseDate(String string) {
        if (Pattern.matches("\\d+ days? ago", string)) {
            var daysCount = string.split(" ")[0];
            return Optional.of(LocalDate.now().minusDays(Integer.parseInt(daysCount)));
        }
        return nextParser == null ? Optional.empty() : nextParser.parseDate(string);
    }
}
