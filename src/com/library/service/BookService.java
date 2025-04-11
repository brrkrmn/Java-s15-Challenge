package com.library.service;

import com.library.models.book.Book;
import com.library.models.book.BookCategory;
import com.library.models.person.Author;

public class BookService {
    private Book book;

    public BookService(Book book) {
        this.book = book;
    }

    public void changeTitle(String title) {
        book.setTitle(title);
    }

    public void changeAuthor(Author author) {
        book.getAuthor().getBooks().remove(book.getId());
        book.setAuthor(author);
        author.getBooks().put(book.getId(), book);
    }

    public void changeYear(int year) {
        book.setYear(year);
    }

    public boolean changePrice(int price) {
        if (price > 5) {
            System.out.println("A book's price can be maximum 5");
            return false;
        }

        if (price <= 0) {
            System.out.println("Books are not for free in this library");
            return false;
        }
        book.setPrice(price);
        return true;
    }

    public void changeCategory(BookCategory category) {
        book.setCategory(category);
    }
}
