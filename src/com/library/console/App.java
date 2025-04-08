package com.library.console;

import com.library.utils.Input;
import com.library.utils.UIHelper;

public class App implements UIHelper {
    private final Input input = new Input();
    private final AuthorFlow authorFlow = new AuthorFlow();

    public void run() {
        printPrompt("Welcome, this is the library management system.");
        Role role = getUserRole();
        switch (role) {
//            case READER: startReaderFlow();
            case AUTHOR: authorFlow.run();
//            case LIBRARIAN: startLibrarianFlow();
        }
    }

    public Role getUserRole() {
        printPrompt("Who are you?");
        printOptions(false, "Reader", "Author", "Librarian");
        return Role.fromInt(input.readIntRange(1, 3));
    }
}
