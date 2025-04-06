package com.library.console;

import com.library.utils.Input;

public class App {
    private final Input input = new Input();

    public void run() {
        System.out.println("\nWelcome, this is the library management system.\n");
        askUserRole();
    }

    public void askUserRole() {
        System.out.println("Who are you?");
        System.out.println("1. Reader");
        System.out.println("2. Author");
        System.out.println("3. Librarian");

        int selection = input.readIntRange("", 1, 3);
        System.out.println("Your selection => " + selection);
    }
}
