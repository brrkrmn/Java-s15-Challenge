package com.library.console;

import com.library.models.Author;
import com.library.utils.DataHelper;
import com.library.utils.Input;
import com.library.utils.UIHelper;

public class AuthorFlow implements UIHelper, DataHelper {
    private final Input input = new Input();
    private Author author;

    public void run() {
        getAuthorName();
        showActions();
    }

    public void getAuthorName() {
        printPrompt("Hello author, what is your name?");
        while (true) {
            String name = input.readLine();

            if (isNullOrEmpty(name)) {
                printPrompt("You must have a name, right? What is it?");
                continue;
            }

            if (isNumeric(name) || containsInteger(name)) {
                printPrompt("Come on, we know your name is not " + name);
                continue;
            }

            this.author = new Author(name);
            return;
        }
    }

    private int showActions() {
        printPrompt(author.getName() + ", what do you want to do?");
        printOptions(true,
                "Submit a book",
                "Request to delete a book",
                "View your books"
        );
        return input.readIntRange(0, 3);
    }
}
