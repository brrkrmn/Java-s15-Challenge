package com.workintech.library;

import java.util.UUID;

public class Book {
    private final long id;

    public Book() {
        id = Long.parseLong(UUID.randomUUID().toString());
    }

    public long getId() {
        return id;
    }
}
