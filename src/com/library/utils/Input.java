package com.library.utils;

import java.util.Scanner;

public class Input implements DataHelper {
    private final Scanner scanner = new Scanner(System.in);

    public String readLine(String prompt) {
        System.out.println(prompt);
        return readLine();
    }

    public String readLine() {
        while (true) {
            String userInput = scanner.nextLine();
            if (isNullOrEmpty(userInput)) {
                System.out.println("This field cannot be empty");
                continue;
            }
            return userInput;
        }
    }

    public int readInt(String prompt) {
        while (true) {
            System.out.println(prompt);
            String userInput = scanner.nextLine();
            try {
                return Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter a number.");
            }
        }
    }

    public int readIntRange(int min, int max) {
        while (true) {
            int value = readInt("");
            if (value >= min && value <= max) {
                return value;
            }
            System.out.printf("\nPlease enter a number between %d and %d.%n", min, max);
        }
    }

    public int readIntRange(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.printf("\nPlease enter a number between %d and %d.%n", min, max);
        }
    }
}
