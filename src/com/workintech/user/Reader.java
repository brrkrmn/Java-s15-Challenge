package com.workintech.user;

import com.workintech.library.Book;

import java.util.Map;

public class Reader extends Person {
    private Map<Long, Book> books;

    public Reader(String name) {
        super(name);
    }

    @Override
    public void whoYouAre() {
        System.out.println(getName() + "is a reader.");
    }

    @Override
    public String toString() {
        return "Reader: " + getName();
    }

    public Map<Long, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<Long, Book> books) {
        this.books = books;
    }
}
