package com.library.models;

public enum BookCategory {
    JOURNAL("Journal"),
    STUDY_BOOK("Study Book"),
    MAGAZINE("Magazine");

    private String category;

    BookCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
