package com.library.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface UIHelper {
    default void printDivider() {
        System.out.println("------------------");
    }

    default void printNextLine() {
        System.out.println("\n");
    }

    default void printPrompt(String prompt) {
        printNextLine();
        System.out.println(prompt);
    }

    default void printOptions(boolean includeExit, String... options) {
        List<String> optionList = new ArrayList<>(List.of(options));

        printDivider();
        for (int i = 0; i < optionList.size(); i++) {
            System.out.println(i + 1 + ". " + optionList.get(i));
        }

        printDivider();
        if (includeExit) System.out.println("0. Exit");
    }

    default void printGoBackPrompt() {
        System.out.println(" --------------------- ");
        System.out.println("| Press 00 to go back |");
        System.out.println(" --------------------- ");
    }
}
