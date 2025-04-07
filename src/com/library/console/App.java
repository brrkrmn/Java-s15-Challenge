package com.library.console;

import com.library.utils.Input;

public class App {
    private final Input input = new Input();
    private final AuthorFlow authorFlow = new AuthorFlow();

    public void run() {
        System.out.println("\nWelcome, this is the library management system.\n");

        Role role = getUserRole();
        switch (role) {
//            case READER: startReaderFlow();
            case AUTHOR: authorFlow.run();
//            case LIBRARIAN: startLibrarianFlow();
        }
    }

    public Role getUserRole() {
        System.out.println("Who are you?");
        System.out.println("1. Reader");
        System.out.println("2. Author");
        System.out.println("3. Librarian");

        return Role.fromInt(input.readIntRange(1, 3));
    }
}
