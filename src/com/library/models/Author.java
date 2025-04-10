package com.library.models;

import java.util.HashMap;
import java.util.Map;

public class Author extends Person {
    private Map<String, Book> books;

    public Author(String name) {
        super(name);
        setBooks(new HashMap<>());
    }

    public void addBook(Book book) {
        books.put(book.getId(), book);
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
        return "\n\n== AUTHOR ================================" +
                "\n     id = " + getId() +
                "\n     name = " + getName() +
                "\n     books = (" + getBooks().size() + ") " +
                            getBooks()
                            .values()
                            .stream()
                            .map(Book::getTitle)
                            .collect(java.util.stream.Collectors.joining(", ")) +
                "\n============================================";
    }
}
