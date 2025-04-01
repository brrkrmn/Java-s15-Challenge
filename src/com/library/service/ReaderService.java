package com.library.service;

import com.library.models.Book;
import com.library.models.Reader;

import java.util.Map;

public class ReaderService {
    private Reader reader;

    public ReaderService(Reader reader) {
        this.reader = reader;
    }

    public void borrowBook(Book book) {
        reader.getBooks().put(book.getId(), book);
    }

    public void returnBook(Book book) {
        reader.getBooks().remove(book.getId());
    }

    public void showBooks() {
        if (reader.getBooks().isEmpty()) {
            System.out.println(reader.getName() + " doesn't have any books.");
        } else {
            System.out.println(reader.getName() + "'s books:");
            for (Map.Entry entry : reader.getBooks().entrySet()) {
                System.out.println(entry.getValue());
            }
        }
    }
}
