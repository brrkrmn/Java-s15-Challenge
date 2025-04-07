package com.library.console;

import com.library.utils.Input;
import com.library.utils.UIHelper;

public class AuthorFlow implements UIHelper {
    private final Input input = new Input();

    public void run() {
        String name = getAuthorName();
        showActions(name);
    }

    public String getAuthorName() {
        printNextLine();
        System.out.println("Hello author, what is your name?");

        while (true) {
            String name = input.readLine();
            if (name != null && !name.trim().isEmpty()) {
                return name;
            }

            System.out.println("You must have a name, right? What is it?");
        }
    }

    private int showActions(String name) {
        printNextLine();
        System.out.println(name + ", what do you want to do?");
        printDivider();
        System.out.println("1. Submit a book");
        System.out.println("2. Request to delete a book");
        System.out.println("3. View your books");
        printDivider();
        System.out.println("0. Exit");
        return input.readIntRange(0, 3);
    }
}
