package com.library.console;

import com.library.models.person.Author;
import com.library.models.book.Book;
import com.library.models.book.BookCategory;
import com.library.service.LibraryService;
import com.library.utils.DataHelper;
import com.library.utils.Input;
import com.library.utils.UIHelper;

import java.util.List;

public abstract class Flow implements DataHelper, UIHelper {
    private final Input input = new Input();

    public abstract void run();
    public abstract int showActions();

    public String askName(String prompt) {
        printPrompt(prompt);
        while (true) {
            String name = input.readLine();

            if (isNullOrEmpty(name)) {
                printPrompt("You must have a name, right? What is it?");
                continue;
            }

            if (isNumeric(name) || containsInteger(name)) {
                printPrompt("Come on, we know your name is not " + name);
                continue;
            }
            return name;
        }
    }

    public void searchBooks(LibraryService libraryService) {
        printPrompt("Search books with: ");
        printOptions(true, "id", "title", "author", "category");
        int option = input.readIntRange(0, 4);

        switch (option) {
            case 0: return;
            case 1:
                String id = input.readLine("Search with book id: ");
                Book book = libraryService.getLibrary().getBooks().get(id);
                System.out.println(book == null ? "There is no book found." : book);
                break;
            case 2:
                List<Book> booksFound = libraryService.searchBooksWithTitle(input.readLine("Search for a title"));
                System.out.println(booksFound.isEmpty() ? "No books found" : booksFound);
                break;
            case 3:
                Author author;
                while (true) {
                    printPrompt("Search with author name: ");
                    printGoBackPrompt();
                    String authorName = input.readLine();

                    if (authorName.equals("00")) {
                        return;
                    }

                    author = libraryService.getLibrary().getAuthors().values().stream().filter(a -> a.getName().equalsIgnoreCase(authorName)).findFirst().orElse(null);

                    if (author == null) {
                        printPrompt("There is no author with this name.");
                        continue;
                    }
                    System.out.println(libraryService.listAuthorBooks(author));
                    break;
                }
                break;
            case 4:
                printPrompt("Search category: ");
                printOptions(false, BookCategory.JOURNAL.getCategory(), BookCategory.STUDY_BOOK.getCategory(), BookCategory.MAGAZINE.getCategory(), BookCategory.FANTASY_NOVEL.getCategory());
                System.out.println(libraryService.listCategoryBooks(BookCategory.fromInt(input.readIntRange(1, 4))));
                break;
        }
    }
}
