package com.studyplanner.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {
    private static final DateTimeFormatter DISPLAY_FORMAT = DateTimeFormatter.ofPattern("MMM dd, yyyy");

    public static LocalDate parseDate(String dateStr) throws DateTimeParseException {
        return LocalDate.parse(dateStr); // Standard YYYY-MM-DD
    }

    public static String formatForDisplay(LocalDate date) {
        return (date == null) ? "N/A" : date.format(DISPLAY_FORMAT);
    }
}