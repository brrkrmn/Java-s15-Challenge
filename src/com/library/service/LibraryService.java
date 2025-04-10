package com.library.service;

import com.library.models.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryService {
    private final Library library;

    public LibraryService() {
        Map<String, Author> defaultAuthors = new HashMap<>();
        Map<String, Author> authorsByName = new HashMap<>();
        Map<String, Book> defaultBooks = new HashMap<>();

        List<Author> authorData = List.of(
                new Author("Patrick Rothfuss"),
                new Author("Marijn Haverbeke"),
                new Author("Robert C. Martin"),
                new Author("J.R.R. Tolkien"),
                new Author("George Orwell"),
                new Author("Aldous Huxley"),
                new Author("F. Scott Fitzgerald"),
                new Author("Yuval Noah Harari"),
                new Author("Stephen Hawking"),
                new Author("Andrew Hunt"),
                new Author("Douglas Crockford"),
                new Author("Various"),
                new Author("Leo Tolstoy"),
                new Author("J.D. Salinger"),
                new Author("Miguel de Cervantes"),
                new Author("Cal Newport")
        );

        for (Author author: authorData) {
            defaultAuthors.put(author.getId(), author);
            authorsByName.put(author.getName(), author);
        }

        List<Book> bookList = List.of(
                new Book(authorsByName.get("Patrick Rothfuss"),"The Name of the Wind", 2007, BookCategory.FANTASY_NOVEL),
                new Book(authorsByName.get("Patrick Rothfuss"),"The Wise Man's Fear", 2011, BookCategory.FANTASY_NOVEL),
                new Book(authorsByName.get("Marijn Haverbeke"), "Eloquent JavaScript", 2018, BookCategory.STUDY_BOOK),
                new Book(authorsByName.get("Robert C. Martin"),"Clean Code", 2008, BookCategory.STUDY_BOOK),
                new Book(authorsByName.get("J.R.R. Tolkien"), "The Hobbit", 1937, BookCategory.FANTASY_NOVEL),
                new Book(authorsByName.get("George Orwell"), "1984", 1949, BookCategory.FANTASY_NOVEL),
                new Book(authorsByName.get("Aldous Huxley"), "Brave New World", 1932, BookCategory.FANTASY_NOVEL),
                new Book(authorsByName.get("F. Scott Fitzgerald"), "The Great Gatsby",1925, BookCategory.FANTASY_NOVEL),
                new Book(authorsByName.get("Yuval Noah Harari"), "Sapiens", 2011, BookCategory.STUDY_BOOK),
                new Book(authorsByName.get("Stephen Hawking"), "A Brief History of Time", 1988, BookCategory.STUDY_BOOK),
                new Book(authorsByName.get("Andrew Hunt"), "The Pragmatic Programmer", 1999, BookCategory.STUDY_BOOK),
                new Book(authorsByName.get("Douglas Crockford"), "JavaScript: The Good Parts", 2008, BookCategory.STUDY_BOOK),
                new Book(authorsByName.get("Various"), "National Geographic Magazine", 2023, BookCategory.MAGAZINE),
                new Book(authorsByName.get("Various"), "Nature", 2023, BookCategory.JOURNAL),
                new Book(authorsByName.get("Various"), "The Economist", 2023, BookCategory.MAGAZINE),
                new Book(authorsByName.get("Leo Tolstoy"), "War and Peace", 1869, BookCategory.FANTASY_NOVEL),
                new Book(authorsByName.get("J.D. Salinger"), "The Catcher in the Rye", 1951, BookCategory.FANTASY_NOVEL),
                new Book(authorsByName.get("Miguel de Cervantes"), "Don Quixote", 1605, BookCategory.FANTASY_NOVEL),
                new Book(authorsByName.get("J.R.R. Tolkien"), "The Fellowship of the Ring", 1954, BookCategory.FANTASY_NOVEL),
                new Book(authorsByName.get("Cal Newport"), "Deep Work", 2016, BookCategory.STUDY_BOOK)
        );

        for (Book book: bookList) {
            defaultBooks.put(book.getId(), book);
        }

        Librarian.initialize("Admin", "secret");
        Library.initialize(defaultAuthors, defaultBooks, Librarian.getInstance());
        this.library = Library.getInstance();
    }

    public Library getLibrary() {
        return library;
    }

    public void newBook(Book book) {
        library.getBooks().put(book.getId(), book);
    }

    public List<Book> searchBooksWithTitle(String title) {
        return library.getBooks().values().stream().filter(book -> book.getTitle().toLowerCase().trim().equals(title.toLowerCase().trim())).toList();
    }

    public List<Book> listAuthorBooks(Author author) {
        return library.getBooks().values().stream().filter(book -> book.getAuthor().equals(author)).toList();
    }

    public List<Book> listCategoryBooks(BookCategory category) {
        return library.getBooks().values().stream().filter(book -> book.getCategory().equals(category)).toList();
    }

    public void getReader() {

    }

    public void lendBook() {

    }

    public void takeBackBook() {

    }

    public void showBook() {

    }
}

