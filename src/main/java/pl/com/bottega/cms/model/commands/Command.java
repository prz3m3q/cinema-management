package pl.com.bottega.cms.model.commands;

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
