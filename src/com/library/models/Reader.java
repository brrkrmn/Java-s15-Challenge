package com.library.models;

import java.util.Map;

public class Reader extends Person {
    private Map<String, Book> borrowedBooks;
    private Map<String, Book> purchasedBooks;
    private MemberRecord memberRecord;

    public Reader(String name) {
        super(name);
    }

    public Map<String, Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public Map<String, Book> getPurchasedBooks() {
        return purchasedBooks;
    }

    public MemberRecord getMemberRecord() {
        return memberRecord;
    }

    public void setBorrowedBooks(Map<String, Book> books) {
        this.borrowedBooks = books;
    }

    public void setPurchasedBooks(Map<String, Book> purchasedBooks) {
        this.purchasedBooks = purchasedBooks;
    }

    public void setMemberRecord(MemberRecord memberRecord) {
        this.memberRecord = memberRecord;
    }

    @Override
    public void whoYouAre() {
        System.out.println(getName() + "is a reader.");
    }

    @Override
    public String toString() {
        return "\n\n== READER ================================" +
                "\n     id = " + getId() +
                "\n     name = " + getName() +
                "\n     borrowed books = (" + (borrowedBooks == null ? "0" : borrowedBooks.size()) + ") " +
                "\n     purchased books = (" + (purchasedBooks == null ? "0" : purchasedBooks.size()) + ") " +
                "\n============================================";
    }
}
