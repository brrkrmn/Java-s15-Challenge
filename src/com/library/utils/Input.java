package com.library.utils;

import java.util.Scanner;

public class Input {
    private final Scanner scanner = new Scanner(System.in);

    public String readLine(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public int readInt(String prompt) {
        while (true) {
            System.out.println(prompt);
            String userInput = scanner.nextLine();
            try {
                return Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    public int readIntRange(int min, int max) {
        while (true) {
            int value = readInt("");
            if (value >= min && value <= max) {
                return value;
            }
            System.out.printf("Please enter a number between %d and %d.%n", min, max);
        }
    }

    public int readIntRange(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.printf("Please enter a number between %d and %d.%n", min, max);
        }
    }
}
