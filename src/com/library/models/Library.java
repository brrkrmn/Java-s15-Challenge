package com.library.models;

import java.util.Map;

public class Library {
    private Map<Long, Book> books;
    private Map<Long, Reader> readers;

    public Library(Map<Long, Book> books) {
        this.setBooks(books);
    }

    public Map<Long, Book> getBooks() {
        return books;
    }

    public Map<Long, Reader> getReaders() {
        return readers;
    }

    public void setBooks(Map<Long, Book> books) {
        this.books = books;
    }

    public void setReaders(Map<Long, Reader> readers) {
        this.readers = readers;
    }
}
