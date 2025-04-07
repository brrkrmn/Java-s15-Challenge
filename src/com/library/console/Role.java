package com.library.console;

public enum Role {
    READER,
    AUTHOR,
    LIBRARIAN;

    public static Role fromInt(int option) {
        return switch (option) {
            case 1 -> READER;
            case 2 -> AUTHOR;
            case 3 -> LIBRARIAN;
            default -> throw new IllegalArgumentException("Invalid role option: " + option);
        };
    }
}

