package com.library.service;

import com.library.models.book.Book;
import com.library.models.book.BookStatus;
import com.library.models.person.Reader;

import java.time.LocalDate;

public class ReaderService {
    private Reader reader;
    private MemberRecordService memberRecordService;

    public ReaderService(Reader reader) {
        this.reader = reader;
        this.memberRecordService = new MemberRecordService(reader.getMemberRecord());
    }

    public void borrowBook(Book book) {
        if (!book.getStatus().equals(BookStatus.AVAILABLE)) {
            System.out.println("This book is not available");
            return;
        }

        boolean canBorrow = memberRecordService.canBorrowBook(book.getPrice());

        if (!canBorrow) {
            System.out.println("You cannot exceed your book limit or your budget");
            return;
        }

        reader.getBorrowedBooks().put(book.getId(), book);
        book.setReader(reader);
        book.setStatus(BookStatus.TAKEN);
        memberRecordService.payBill(book.getPrice());
        memberRecordService.increaseBooksIssued();
    }

    public void returnBook(Book book) {
        if (!reader.getBorrowedBooks().containsKey(book.getId())) {
            System.out.println("This book is not in your borrowed list.");
            return;
        }

        reader.getBorrowedBooks().remove(book.getId());
        book.setReader(null);
        book.setStatus(BookStatus.AVAILABLE);
        memberRecordService.refund(book.getPrice());
        memberRecordService.decreaseBooksIssued();
    }

    public void purchaseBook(Book book) {
        if (!book.getStatus().equals(BookStatus.AVAILABLE)) {
            System.out.println("This book is not available");
            return;
        }

        boolean canPurchase = memberRecordService.canPurchaseBook(book.getPrice());

        if (!canPurchase) {
            System.out.println("You need more $$ to buy this book.");
            return;
        }

        reader.getPurchasedBooks().put(book.getId(), book);
        book.setStatus(BookStatus.PURCHASED);
        book.setOwner(reader);
        book.setDateOfPurchase(LocalDate.now());
        memberRecordService.payBill(book.getPrice());
    }

    public void showBorrowedBooks() {
        if (reader.getBorrowedBooks().isEmpty()) {
            System.out.println("You don't have any borrowed books.");
        } else {
            System.out.println(
                    "Books you have borrowed: "
                    + reader.getBorrowedBooks().values()
            );
        }
    }

    public void showPurchasedBooks() {
        if (reader.getPurchasedBooks().isEmpty()) {
            System.out.println("You don't have any purchased books.");
        } else {
            System.out.println(
                    "Books you have purchased: "
                    + reader.getPurchasedBooks().values()
            );
        }
    }
}
