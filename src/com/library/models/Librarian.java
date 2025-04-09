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
        if (password.length() < 3) {
            System.out.println("Password should have minimum 3 characters.");
        } else if (password.length() > 10) {
            System.out.println("Password should have maximum 10 characters.");
        } else {
            this.password = password;
        }
    }

    @Override
    public void whoYouAre() {
        System.out.println(getName() + "is a librarian.");
    }

    @Override
    public String toString() {
        return "Librarian {" +
                "\n id = " + getId() +
                "\n name = " + getName() +
                "\n password = " + password +
                "\n}\n";
    }
}
