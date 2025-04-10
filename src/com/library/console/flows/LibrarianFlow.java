package com.library.console.flows;

import com.library.console.Flow;
import com.library.models.Author;
import com.library.models.Book;
import com.library.models.BookCategory;
import com.library.service.BookService;
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
                case 1:
                    addBook();
                    break;
                case 2:
                    editBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    printPrompt("----------Books----------\n" + libraryService.getLibrary().getBooks().values());
                    break;
                case 5:
                    printPrompt("----------Authors----------\n" + libraryService.getLibrary().getAuthors().values());
                    break;
                case 6:
                    printPrompt("----------Readers----------\n" + (libraryService.getLibrary().getReaders().isEmpty()
                            ? "Library does not have any readers"
                            : libraryService.getLibrary().getReaders().values()));
                    break;
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
                "Edit a book",
                "Delete a book",
                "Show books",
                "Show authors",
                "Show readers"
        );
        return input.readIntRange(0,6);
    }

    public void addBook() {
        String title;
        Author author;

        while (true) {
            title = input.readLine("What is the title of the book?");
            if (isNullOrEmpty(title)) {
                printPrompt("Title cannot be empty.");
                continue;
            }
            break;
        }

        while (true) {
            String authorId = input.readLine("Who is the id of the author?");
            if (isNullOrEmpty(authorId)) {
                printPrompt("Author id is required.");
                continue;
            }

            author = libraryService.getLibrary().getAuthors().get(authorId);

            if (author == null) {
                printPrompt("There is no author with this id.");
            }
            break;
        }

        int year = input.readInt("What is the year of the book?");

        printPrompt("Select the category of the book");
        printOptions(false, BookCategory.JOURNAL.getCategory(), BookCategory.STUDY_BOOK.getCategory(), BookCategory.MAGAZINE.getCategory(), BookCategory.FANTASY_NOVEL.getCategory());
        BookCategory category = BookCategory.fromInt(input.readIntRange(1, 4));

        libraryService.newBook(new Book(author, title, year, category));
    }

    public void editBook() {
        Book book;
        BookService bookService;

        while (true) {
            printPrompt("Enter the id of the book you want to edit");
            printGoBackPrompt();
            String id = input.readLine();

            if (id.equals("00")) {
                break;
            }

            if (isNullOrEmpty(id)) {
                printPrompt("You must provide an id");
            }

            book = libraryService.getLibrary().getBooks().get(id);

            if (book == null) {
                printPrompt("There is no book with this id");
                continue;
            }
            printPrompt("Here's the book you're looking for: " + book);
            bookService = new BookService(book);

            while (true) {
                printPrompt("Which field do you want to change?");
                printOptions(true, "Title", "Author", "Year", "Price", "Category");
                int option = input.readIntRange(0, 5);

                switch (option) {
                    case 0: return;
                    case 1:
                        bookService.changeTitle(input.readLine("What is the new title?"));
                        break;
                    case 2:
                        Author author;
                        while (true) {
                            String authorId = input.readLine("What is the new author's id?");
                            author = libraryService.getLibrary().getAuthors().get(authorId);

                            if (author == null) {
                                printPrompt("There is no author with this id.");
                                continue;
                            }
                            bookService.changeAuthor(author);
                        }
                    case 3:
                        bookService.changeYear(input.readInt("What is the new year?"));
                        break;
                    case 4:
                        while (true) {
                            int price = input.readInt("What is the new price?");
                            if (bookService.changePrice(price)) break;
                        }
                        break;
                    case 5:
                        printPrompt("What is the new category");
                        printOptions(false, BookCategory.JOURNAL.getCategory(), BookCategory.STUDY_BOOK.getCategory(), BookCategory.MAGAZINE.getCategory(), BookCategory.FANTASY_NOVEL.getCategory());
                        bookService.changeCategory(BookCategory.fromInt(input.readIntRange(1, 4)));
                }
            }
        }
    }

    public void deleteBook() {
        while (true) {
            printPrompt("Enter the id of the book you want to delete.");
            printGoBackPrompt();
            String id = input.readLine();

            if (id.equals("00")) {
                break;
            }

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
