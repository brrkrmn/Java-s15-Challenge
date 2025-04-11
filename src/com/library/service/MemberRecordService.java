package com.library.service;

import com.library.models.MemberRecord;

public class MemberRecordService {
    private final MemberRecord memberRecord;

    public MemberRecordService(MemberRecord memberRecord) {
        this.memberRecord = memberRecord;
    }

    public void createInvoice() {
        System.out.println(
                "\n\nYou have purchased a " + memberRecord.getMemberType() + " member record."
                + "\nThe amount we took from you will be stored in your member card."
                + "\nYou can use that money to borrow books from the library."
                + "\nWhen you return a book, the book's price will be transferred back to your account.");

        System.out.println(
                  "\n-----------------------------------"
                + "\n       Member Record Invoice      "
                + "\n-----------------------------------"
                + "\n       Amount: " + memberRecord.getBudget()
                + "\n       Payer: " + memberRecord.getName()
                + "\n       Purchase: " + memberRecord.getMemberType()
                + "\n       Date: " + memberRecord.getDateOfMembership()
                + "\n-----------------------------------"
        );
    }

    public void viewMemberCard() {
        System.out.println(
                  "\n--------------------------------"
                + "\n          Member Card           "
                + "\n--------------------------------"
                + "\n       Name: " + memberRecord.getName()
                + "\n       Member Type: " + memberRecord.getMemberType()
                + "\n       Book Limit: " + memberRecord.getMaxBookLimit()
                + "\n       Budget: " + memberRecord.getBudget() + "$"
                + "\n       Books Issued: " + memberRecord.getIssuedBooks()
                + "\n\n       Address: " + memberRecord.getAddress()
                + "\n       Phone: " + memberRecord.getPhone()
                + "\n       Access Key: " + memberRecord.getAccessKey()
                + "\n       Date Created: " + memberRecord.getDateOfMembership()
                + "\n--------------------------------"
        );
    }

    public void payBill(int price) {
        memberRecord.setBudget(memberRecord.getBudget() - price);
    }

    public void refund(int price) {
        memberRecord.setBudget(memberRecord.getBudget() + price);
    }

    public void increaseBooksIssued() {
        memberRecord.setIssuedBooks(memberRecord.getIssuedBooks() + 1);
    }

    public void decreaseBooksIssued() {
        memberRecord.setIssuedBooks(memberRecord.getIssuedBooks() - 1);
    }

    public boolean canBorrowBook(int price) {
        return (memberRecord.getIssuedBooks() < memberRecord.getMaxBookLimit())
                && (memberRecord.getBudget() >= price);
    }

    public boolean canPurchaseBook(int price) {
        return memberRecord.getBudget() >= price;
    }
}
