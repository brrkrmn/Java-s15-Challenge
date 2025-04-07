package com.library.utils;

public interface UIHelper {
    default void printDivider() {
        System.out.println("------------------");
    }

    default void printNextLine() {
        System.out.println("\n");
    }
}
