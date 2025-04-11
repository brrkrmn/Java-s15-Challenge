package com.library.models;

import com.library.models.book.Book;
import com.library.models.person.Author;
import com.library.models.person.Librarian;
import com.library.models.person.Reader;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books;
    private Map<String, Reader> readers;
    private Map<String, Author> authors;
    private Librarian librarian;

    private static Library instance;

    private Library(Map<String, Author> authors, Map<String, Book> books, Librarian librarian) {
        this.setAuthors(authors);
        this.setBooks(books);
        this.setLibrarian(librarian);
        this.setReaders(new HashMap<>());
    }

    public static void initialize(Map<String, Author> authors, Map<String, Book> books, Librarian librarian) {
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

    public Map<String, Book> getBooks() {
        return books;
    }

    public Map<String, Reader> getReaders() {
        return readers;
    }

    public Map<String, Author> getAuthors() {
        return authors;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setBooks(Map<String, Book> books) {
        this.books = books;
    }

    public void setReaders(Map<String, Reader> readers) {
        this.readers = readers;
    }

    public void setAuthors(Map<String, Author> authors) {
        this.authors = authors;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }
}
