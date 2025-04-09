package com.library.console.flows;

import com.library.console.Flow;
import com.library.models.Librarian;

public class LibrarianFlow extends Flow {
    private Librarian librarian;

    @Override
    public void run() {

    }

    public void register() {
        String name = askName("What is your name?");

    }


}
