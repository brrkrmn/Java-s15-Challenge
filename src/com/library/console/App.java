package com.library.console;

import com.library.console.flows.AuthorFlow;
import com.library.console.flows.LibrarianFlow;
import com.library.console.flows.ReaderFlow;
import com.library.service.LibraryService;
import com.library.utils.Input;
import com.library.utils.UIHelper;

public class App implements UIHelper {
    private final LibraryService libraryService = new LibraryService();
    private final AuthorFlow authorFlow = new AuthorFlow(libraryService);
    private final ReaderFlow readerFlow = new ReaderFlow(libraryService);
    private final LibrarianFlow librarianFlow = new LibrarianFlow(libraryService);

    public void run() {
        while (true) {
            printPrompt("Welcome, this is the library management system.");
            Role role = getUserRole();
            switch (role) {
                case READER:
                    readerFlow.run();
                    break;
                case AUTHOR:
                    authorFlow.run();
                    break;
                case LIBRARIAN:
                    librarianFlow.run();
                    break;
            }
        }
    }

    public Role getUserRole() {
        printPrompt("Who are you?");
        printOptions(false, "Reader", "Author", "Librarian");
        return Role.fromInt(Input.readIntRange(1, 3));
    }
}
