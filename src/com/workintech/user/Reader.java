package com.workintech.user;

import com.workintech.library.Book;

import java.util.Map;

public class Reader extends Person {
    private Map<Long, Book> books;

    public Reader(String name) {
        super(name);
    }

    public void borrowBook(Book book) {
        books.put(book.getId(), book);
    }

    public void returnBook(Book book) {
        books.remove(book.getId());
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println(getName() + " doesn't have any books.");
        } else {
            System.out.println(getName() + "'s books:");
            for (Map.Entry entry : books.entrySet()) {
                System.out.println(entry.getValue());
            }
        }
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
