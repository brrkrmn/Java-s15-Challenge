package com.library.service;

import com.library.models.MemberRecord;

public class MemberRecordService {
    private MemberRecord memberRecord;

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

    public void showMemberCard() {
        System.out.println("---------------------");
        System.out.println("     Member Card     ");
        System.out.println("---------------------");
        System.out.println("     name: " + memberRecord.getName());
        System.out.println("     member record type: " + memberRecord.getMemberType());
        System.out.println("     joined at: " + memberRecord.getDateOfMembership());
        System.out.println("     book limit: " + memberRecord.getMaxBookLimit());
        System.out.println("     books issued: " + memberRecord.getIssuedBooks());
        System.out.println("---------------------");
    }

    public void showPersonalDetails(String accessKey) {
        if (!validateMember(accessKey)) {
            System.out.println("You cannot view this member's details.");
            return;
        }

        System.out.println("---------------------");
        System.out.println("    Member Details    ");
        System.out.println("---------------------");
        System.out.println("     id: " + memberRecord.getId());
        System.out.println("     address: " + memberRecord.getAddress());
        System.out.println("     phone: " + memberRecord.getPhone());
        System.out.println("     access key: " + memberRecord.getAccessKey());
        System.out.println("---------------------");
    }

    public boolean validateMember(String accessKey) {
        return accessKey.equals(memberRecord.getAccessKey());
    }

    public void increaseBooksIssued() {
        memberRecord.setIssuedBooks(memberRecord.getIssuedBooks() + 1);
    }

    public void decreaseBooksIssued() {
        memberRecord.setIssuedBooks(memberRecord.getIssuedBooks() - 1);
    }

    public void payBill() {

    }
}
