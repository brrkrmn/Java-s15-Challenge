package com.library.console.flows;

import com.library.console.Flow;
import com.library.models.Author;
import com.library.utils.Input;

public class AuthorFlow extends Flow {
    private final Input input = new Input();
    private Author author;

    @Override
    public void run() {
        getName();
        showActions();
    }

    public void getName() {
        String name = askName("Hello author, what is your name?");
        this.author = new Author(name);
    }

    public int showActions() {
        printPrompt(author.getName() + ", what do you want to do?");
        printOptions(true,
                "Submit a book",
                "Request to delete a book",
                "View your books"
        );
        return input.readIntRange(0, 3);
    }
}
