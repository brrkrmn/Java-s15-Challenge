package com.library.service;

import com.library.models.Member;

public class MemberService {
    private Member member;

    public MemberService(Member member) {
        this.member = member;
    }

    public void showMemberCard() {
        System.out.println("---------------------");
        System.out.println("     Member Card     ");
        System.out.println("---------------------");
        System.out.println("     name: " + member.getName());
        System.out.println("     member type: " + member.getMemberType());
        System.out.println("     joined at: " + member.getDateOfMembership());
        System.out.println("     book limit: " + member.getMaxBookLimit());
        System.out.println("     books issued: " + member.getIssuedBooks());
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
        System.out.println("     id: " + member.getId());
        System.out.println("     address: " + member.getAddress());
        System.out.println("     phone: " + member.getPhone());
        System.out.println("     access key: " + member.getAccessKey());
        System.out.println("---------------------");
    }

    public boolean validateMember(String accessKey) {
        return accessKey.equals(member.getAccessKey());
    }

    public void increaseBooksIssued() {
        member.setIssuedBooks(member.getIssuedBooks() + 1);
    }

    public void decreaseBooksIssued() {
        member.setIssuedBooks(member.getIssuedBooks() - 1);
    }

    public void payBill() {

    }
}
