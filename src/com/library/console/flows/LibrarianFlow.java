package com.library.console.flows;

import com.library.console.Flow;
import com.library.models.Book;
import com.library.models.Librarian;
import com.library.service.LibrarianService;
import com.library.service.LibraryService;
import com.library.utils.Input;

public class LibrarianFlow extends Flow {
    private LibraryService libraryService;
    private LibrarianService librarianService;
    private final Input input = new Input();

    public LibrarianFlow(LibraryService libraryService) {
        this.libraryService = libraryService;
        this.librarianService = new LibrarianService();
    }

    @Override
    public void run() {
        if (!verifyLibrarian()) {
            printPrompt("Wrong password. Returning to the main menu...");
            return;
        }

        while (true) {
            int actionNo = showActions();
            switch (actionNo) {
                case 0: return;
                case 3: deleteBook();
            }
        }
    }

    public boolean verifyLibrarian() {
        while (true) {
            String password = input.readLine("Enter the password to log in as librarian");

            if (isNullOrEmpty(password)) {
                printPrompt("Password is required.");
                continue;
            }

            return password.equals(librarianService.getLibrarian().getPassword());
        }
    }

    public int showActions() {
        printPrompt("Librarian, what do you want to do?");
        printOptions(true,
                "Add new book",
                "Update a book",
                "Delete a book",
                "Search a book",
                "Search a category",
                "Search an author");
        return input.readIntRange(0, 6);
    }

    public void deleteBook() {
        while (true) {
            String id = input.readLine("Enter the id of the book you want to delete.");

            if (isNullOrEmpty(id)) {
                printPrompt("You must provide an id");
                continue;
            }

            Book book = libraryService.getLibrary().getBooks().get(id);

            if (book == null) {
               printPrompt("No book exists with this id.");
               continue;
            }

            printPrompt("Here's the book details: \n" + book.toString());
            printPrompt("Continue with deletion?");
            printOptions(false, "Yes, delete", "Cancel");
            int option = input.readIntRange(1, 2);

            switch (option) {
                case 1:
                    libraryService.getLibrary().getBooks().remove(id);
                    book.getAuthor().getBooks().remove(id);
                case 2: return;
            }
        }
    }
}
