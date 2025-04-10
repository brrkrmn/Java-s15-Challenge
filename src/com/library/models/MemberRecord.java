package com.library.models;

import java.time.LocalDate;
import java.util.Objects;

public class MemberRecord {
    private final String id;
    private MemberType memberType;
    private LocalDate dateOfMembership;
    private int maxBookLimit;
    private int budget;
    private int issuedBooks;
    private String name;
    private String address;
    private String phone;
    private String accessKey;

    public MemberRecord(Reader reader, MemberType memberType, String address, String phone, String accessKey) {
        this.id = reader.getId();
        this.setName(reader.getName());
        this.setAddress(address);
        this.setPhone(phone);
        this.setAccessKey(accessKey);
        this.setDateOfMembership(LocalDate.now());
        this.setMemberType(memberType);
        this.setMaxBookLimit(memberType == MemberType.STUDENT ? 5 : 20);
        this.setBudget(memberType == MemberType.STUDENT ? 15 : 30);
    }

    public String getId() {
        return id;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public LocalDate getDateOfMembership() {
        return dateOfMembership;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public int getIssuedBooks() {
        return issuedBooks;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getBudget() {
        return budget;
    }

    public String getPhone() {
        return phone;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public void setDateOfMembership(LocalDate dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
    }

    public void setMaxBookLimit(int maxBookLimit) {
        this.maxBookLimit = maxBookLimit;
    }

    public void setIssuedBooks(int issuedBooks) {
        this.issuedBooks = issuedBooks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAccessKey(String accessKey) {
        if (accessKey.length() < 3) {
            System.out.println("Please enter minimum 3 characters.");
            return;
        } else if (accessKey.length() > 10) {
            System.out.println("Please enter maximum 10 characters.");
            return;
        }
        this.accessKey = accessKey;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", memberType=" + memberType +
                ", dateOfMembership=" + dateOfMembership +
                ", maxBookLimit=" + maxBookLimit +
                ", issuedBooks=" + issuedBooks +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", accessKey='" + accessKey + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        MemberRecord memberRecord = (MemberRecord) obj;
        return memberRecord.getId().equals(id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
