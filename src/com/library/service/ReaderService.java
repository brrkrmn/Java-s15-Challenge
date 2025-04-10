package com.library.service;

import com.library.models.Book;
import com.library.models.BookStatus;
import com.library.models.Reader;

import java.time.LocalDate;
import java.util.Map;

public class ReaderService {
    private Reader reader;

    public ReaderService(Reader reader) {
        this.reader = reader;
    }

    public void borrowBook(Book book) {
        reader.getBorrowedBooks().put(book.getId(), book);
        book.setReader(reader);
        book.setStatus(BookStatus.TAKEN);
    }

    public void returnBook(Book book) {
        reader.getBorrowedBooks().remove(book.getId());
        book.setReader(null);
        book.setStatus(BookStatus.AVAILABLE);
    }

    public void purchaseBook(Book book) {
        reader.getPurchasedBooks().put(book.getId(), book);
        book.setStatus(BookStatus.PURCHASED);
        book.setOwner(reader);
        book.setDateOfPurchase(LocalDate.now());
    }

    public void showBorrowedBooks() {
        if (reader.getBorrowedBooks().isEmpty()) {
            System.out.println(reader.getName() + " doesn't have any borrowed books.");
        } else {
            System.out.println(reader.getName() + "'s books:");
            for (Map.Entry entry : reader.getBorrowedBooks().entrySet()) {
                System.out.println(entry.getValue());
            }
        }
    }

    public void showPurchasedBooks() {
        if (reader.getPurchasedBooks().isEmpty()) {
            System.out.println(reader.getName() + " doesn't have any borrowed books.");
        } else {
            System.out.println(reader.getName() + "'s books:");
            for (Map.Entry entry : reader.getPurchasedBooks().entrySet()) {
                System.out.println(entry.getValue());
            }
        }
    }
}
