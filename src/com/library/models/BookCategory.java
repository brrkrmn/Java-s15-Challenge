package com.library.models;

public enum BookCategory {
    JOURNAL("Journal"),
    STUDY_BOOK("Study Book"),
    MAGAZINE("Magazine"),
    FANTASY_NOVEL("Fantasy Novel");

    private String category;

    BookCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public static BookCategory fromInt(int option) {
        return switch (option) {
            case 1 -> JOURNAL;
            case 2 -> STUDY_BOOK;
            case 3 -> MAGAZINE;
            case 4 -> FANTASY_NOVEL;
            default -> throw new IllegalArgumentException("Invalid category option: " + option);
        };
    }
}
