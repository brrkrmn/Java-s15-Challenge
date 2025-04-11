package com.library.service;

import com.library.models.person.Librarian;

public class LibrarianService {
    private Librarian librarian;

    public LibrarianService() {
        this.librarian = Librarian.getInstance();
    }

    public Librarian getLibrarian() {
        return librarian;
    }
}
