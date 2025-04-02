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
}
