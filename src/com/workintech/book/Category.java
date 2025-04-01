package com.workintech.book;

public enum Category {
    JOURNAL("Journal"),
    STUDY_BOOK("Study Book"),
    MAGAZINE("Magazine");

    private String category;

    Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
