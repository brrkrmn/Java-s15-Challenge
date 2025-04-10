package com.library.console.flows;

import com.library.console.Flow;
import com.library.models.Author;
import com.library.models.Book;
import com.library.models.BookCategory;
import com.library.service.AuthorService;
import com.library.service.LibraryService;
import com.library.utils.Input;

public class AuthorFlow extends Flow {
    private final Input input = new Input();
    private final LibraryService libraryService;
    private Author author;
    private AuthorService authorService;

    public AuthorFlow(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @Override
    public void run() {
        setAuthor();

        while (true) {
            int actionNo = showActions();
            switch (actionNo) {
                case 0: return;
                case 1: submitBook(); break;
                case 2: deleteBook(); break;
                case 3: authorService.showBooks(); break;
            }
        }
    }

    public void setAuthor() {
        String name = askName("Hello author, what is your name?");

        Author existingAuthor = libraryService.getLibrary().getAuthors().values().stream()
                .filter(a -> a.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

        if (existingAuthor != null) {
            printPrompt("Welcome back");
            this.author = existingAuthor;
        } else {
            this.author = new Author(name);
            libraryService.getLibrary().getAuthors().put(author.getId(), author);
        }

        this.authorService = new AuthorService(author);
    }

    public int showActions() {
        printPrompt(author.getName() + ", what do you want to do?");
        printOptions(true,
                "Submit a book",
                "Delete a book",
                "View your books"
        );
        return input.readIntRange(0, 3);
    }

    public void submitBook() {
        String title;

        while (true) {
            title = input.readLine("What is the title of your book?");
            if (isNullOrEmpty(title)) {
                printPrompt("You must provide a title.");
                continue;
            }
            break;
        }

        int year = input.readInt("Year?");

        printPrompt("Category");
        printOptions(false, BookCategory.JOURNAL.getCategory(), BookCategory.STUDY_BOOK.getCategory(), BookCategory.MAGAZINE.getCategory(), BookCategory.FANTASY_NOVEL.getCategory());
        BookCategory category = BookCategory.fromInt(input.readIntRange(1, 4));

        libraryService.newBook(new Book(author, title, year, category));
        printPrompt("Book submitted successfully, you can view it in your books.");
    }

    public void deleteBook() {
        if (author.getBooks().isEmpty()) {
            printPrompt("You don't have any books to delete.");
            return;
        }

        while (true) {
            printPrompt("Please enter the id of the book you want to delete.");
            printGoBackPrompt();
            String id = input.readLine();
            
            if (id.equals("00")) {
                break;
            }

            if (isNullOrEmpty(id)) {
                printPrompt("You must provide an id.");
                continue;
            }

            Book book = libraryService.getLibrary().getBooks().get(id);

            if (book == null) {
                printPrompt("Sorry, no book found with this ID.");
                continue;
            }

            if (!book.getAuthor().equals(author)) {
                printPrompt("Sorry, you cannot delete another author's book.");
                continue;
            }

            libraryService.getLibrary().getBooks().remove(id);
            author.getBooks().remove(id);
            printPrompt("Book deleted successfully");
            return;
        }
    }
}
