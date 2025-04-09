package com.library.models;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Long, Book> books;
    private Map<Long, Reader> readers;
    private Map<Long, Author> authors;
    private Librarian librarian;

    private static Library instance;

    private Library(Map<Long, Author> authors, Map<Long, Book> books, Librarian librarian) {
        this.setAuthors(authors);
        this.setBooks(books);
        this.setLibrarian(librarian);
        this.setReaders(new HashMap<>());
    }

    public static void initialize(Map<Long, Author> authors, Map<Long, Book> books, Librarian librarian) {
        if (instance != null) {
            throw new IllegalStateException("Library is already initialized.");
        }
        instance = new Library(authors, books, librarian);
    }

    public static Library getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Library has not been initialized yet.");
        }
        return instance;
    }

    public Map<Long, Book> getBooks() {
        return books;
    }

    public Map<Long, Reader> getReaders() {
        return readers;
    }

    public Map<Long, Author> getAuthors() {
        return authors;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setBooks(Map<Long, Book> books) {
        this.books = books;
    }

    public void setReaders(Map<Long, Reader> readers) {
        this.readers = readers;
    }

    public void setAuthors(Map<Long, Author> authors) {
        this.authors = authors;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }
}
