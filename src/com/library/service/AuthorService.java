package com.library.service;

import com.library.models.person.Author;

import java.util.Map;

public class AuthorService {
    private Author author;

    public AuthorService(Author author) {
        this.author = author;
    }

    public void showBooks() {
        if (author.getBooks().isEmpty()) {
            System.out.println("\n" + author.getName() + ", you don't have any books.");
        } else {
            System.out.println("\n" +  author.getName() + "'s books: ");
            for (Map.Entry entry : author.getBooks().entrySet()) {
                System.out.println(entry.getValue());
            }
        }
    }

}
