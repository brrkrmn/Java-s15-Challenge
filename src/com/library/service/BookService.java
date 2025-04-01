package com.library.service;

import com.library.models.Book;
import com.library.models.BookStatus;
import com.library.models.Reader;

public class BookService {
    private Book book;

    public BookService(Book book) {
        this.book = book;
    }

    public void changeOwner(Reader owner) {
        book.setOwner(owner);
    }

    public void updateStatus(BookStatus status) {
        book.setStatus(status);
    }
}
