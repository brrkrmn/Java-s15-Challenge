package com.library.models;

public enum BookStatus {
    AVAILABLE("Available"),
    TAKEN("Taken"),
    SOLD("Sold");

    private String status;

    BookStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
