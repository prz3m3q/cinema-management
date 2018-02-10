package pl.com.bottega.cms.model.commands;

import java.text.DateFormatSymbols;
import java.util.*;

public interface Command {

    default void validate(ValidationErrors validationErrors) {

    }

    default void validatePresence(ValidationErrors errors, String field, String value) {
        if (value == null || value.trim().length() == 0) {
            errors.add(field, "can't be blank");
        }
    }

    default void validatePresence(ValidationErrors errors, String field, Object value) {
        if (value == null) {
            errors.add(field, "can't be blank");
        }
    }

    default void validateNegativeNumber(ValidationErrors errors, String field, Integer value) {
        if (value == null) {
            errors.add(field, "can't be blank");
        }
        if (value < 0) {
            errors.add(field, "can't be negative");
        }
    }

    default void validatePresence(ValidationErrors errors, String field, Set value) {
        if (value == null || value.size() == 0) {
            errors.add(field, "can't be empty");
        }
        try {
            if (value != null && value.stream().anyMatch(v -> v.toString().trim().length() == 0)) {
                errors.add(field, "can't be empty values");
            }
        } catch (NullPointerException ex) {
            errors.add(field, "can't contain null values");
        }
    }

    default void validateWeekdays(ValidationErrors errors, String field, Set value) {
        if (value == null) {
            errors.add(field, "can't be blank");
        }
        String[] weekdays = DateFormatSymbols.getInstance(Locale.US).getWeekdays();
        if (value != null && !Arrays.stream(weekdays).anyMatch(day -> value.contains(day))) {
            errors.add(field, "some name of weekday is wrong");
        }
    }

    default void validatePresence(ValidationErrors errors, String fieldOne, Set valueOne, String fieldTwo, ShowsCalendar valueTwo) {
        if (valueOne == null && valueTwo == null) {
            errors.add(fieldOne, "can't be blank");
            errors.add(fieldTwo, "can't be blank");
        }
        if (valueOne != null && valueTwo != null) {
            errors.add(fieldOne, "give only the one date period");
            errors.add(fieldTwo, "give only the one date period");
        }
    }

    default void validateMinLength(ValidationErrors errors, String field, String value, int minLength) {
        if (value != null && value.length() < minLength) {
            errors.add(field, "min length is " + minLength);
        }
    }

    default void validateFormat(ValidationErrors errors, String field, String value, String format) {
        if(value != null && !value.matches(format)) {
            errors.add(field, "invalid format");
        }
    }


}
