package com.library.models;

import java.util.Map;

public class Author extends Person {
    private Map<String, Book> books;

    public Author(String name) {
        super(name);
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<String, Book> books) {
        this.books = books;
    }

    @Override
    public void whoYouAre() {
        System.out.println(getName() + "is an author.");
    }

    @Override
    public String toString() {
        return "Author: " + getName();
    }
}
