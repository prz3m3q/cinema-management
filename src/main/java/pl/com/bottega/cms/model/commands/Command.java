package pl.com.bottega.cms.model.commands;

import pl.com.bottega.cms.model.Ticket;

import java.util.*;
import java.util.stream.Collectors;

public interface Command {

    default void validate(ValidationErrors validationErrors) {

    }

    default void validateDuplicatte(ValidationErrors errors,String field, List<String> listKind ){
        List<String> testListKind;
        testListKind = listKind.stream().distinct().collect(Collectors.toList());
        if(testListKind.size() != listKind.size())
        errors.add(field,"Can not be duplicate in tisket");
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
        if (value.size() == 0) {
            errors.add(field, "can't be empty");
        }
        if (value.stream().anyMatch(v -> v.toString().trim().length() == 0)) {
            errors.add(field, "can't be empty values");
        }
    }

    default void validatePresence(ValidationErrors errors, String fieldOne, Object valueOne, String fieldTwo, Object valueTwo) {
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
