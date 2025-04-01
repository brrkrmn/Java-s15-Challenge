package com.library.service;

import com.library.models.Author;
import com.library.models.Book;

import java.util.Map;

public class AuthorService {
    private Author author;

    public AuthorService(Author author) {
        this.author = author;
    }

    public void newBook(Book book) {
        author.getBooks().put(book.getId(), book);
    }

    public void showBooks() {
        if (author.getBooks().isEmpty()) {
            System.out.println(author.getName() + " doesn't have any books.");
        } else {
            System.out.println(author.getName() + "'s books: ");
            for (Map.Entry entry : author.getBooks().entrySet()) {
                System.out.println(entry.getValue());
            }
        }
    }

}
