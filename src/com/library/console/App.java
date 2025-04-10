package com.library.console;

import com.library.console.flows.AuthorFlow;
import com.library.console.flows.LibrarianFlow;
import com.library.console.flows.ReaderFlow;
import com.library.service.LibraryService;
import com.library.utils.Input;
import com.library.utils.UIHelper;

public class App implements UIHelper {
    private final Input input = new Input();
    private final LibraryService libraryService = new LibraryService();
    private final AuthorFlow authorFlow = new AuthorFlow(libraryService);
    private final ReaderFlow readerFlow = new ReaderFlow();
    private final LibrarianFlow librarianFlow = new LibrarianFlow(libraryService);

    public void run() {
        while (true) {
            printPrompt("Welcome, this is the library management system.");
            Role role = getUserRole();
            switch (role) {
                case READER: readerFlow.run();
                case AUTHOR: authorFlow.run();
                case LIBRARIAN: librarianFlow.run();
            }
        }
    }

    public Role getUserRole() {
        printPrompt("Who are you?");
        printOptions(false, "Reader", "Author", "Librarian");
        return Role.fromInt(input.readIntRange(1, 3));
    }
}
