package com.library.models;

public enum MemberType {
    STUDENT("Student"),
    FACULTY("Faculty");

    private String memberType;

    MemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getMemberType() {
        return memberType;
    }

    public static MemberType fromInt(int option) {
        return switch (option) {
            case 1 -> STUDENT;
            case 2 -> FACULTY;
            default -> throw new IllegalArgumentException("Invalid category option: " + option);
        };
    }
}
