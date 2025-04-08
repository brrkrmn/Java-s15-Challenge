package com.library.utils;

public interface DataHelper {
    default boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    default boolean isNumeric(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    default boolean containsInteger(String value) {
        return value.matches(".*\\d+.*");
    }
}
