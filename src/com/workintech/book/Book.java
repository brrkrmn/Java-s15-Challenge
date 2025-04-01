package com.workintech.book;

import com.workintech.user.Author;

import java.util.UUID;

public class Book {
    private final long id;
    private Author author;
    private String name;
    private final int credit = 1;

    public Book() {
        id = Long.parseLong(UUID.randomUUID().toString());
    }

    public long getId() {
        return id;
    }
}

