package com.library.models;

public class Librarian extends Person {
    private String password;

    public Librarian(String name, String password) {
        super(name);
        this.setPassword(password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void whoYouAre() {
        System.out.println(getName() + "is a librarian.");
    }

    @Override
    public String toString() {
        return "Librarian: " + getName();
    }
}
