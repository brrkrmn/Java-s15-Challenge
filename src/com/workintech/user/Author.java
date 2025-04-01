package com.workintech.user;

import com.workintech.book.Book;

import java.util.Map;

public class Author extends Person {
    private Map<Long, Book> books;

    public Author(String name) {
        super(name);
    }

    public void newBook(Book book) {
        books.put(book.getId(), book);
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println(getName() + " doesn't have any books.");
        } else {
            System.out.println(getName() + "'s books: ");
            for (Map.Entry entry : books.entrySet()) {
                System.out.println(entry.getValue());
            }
        }
    }

    @Override
    public void whoYouAre() {
        System.out.println(getName() + "is an author.");
    }

    @Override
    public String toString() {
        return "Author: " + getName();
    }

    public Map<Long, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<Long, Book> books) {
        this.books = books;
    }
}
