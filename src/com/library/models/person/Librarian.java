package com.library.models.person;

public class Librarian extends Person {
    private String password;
    private static Librarian instance;

    private Librarian(String name, String password) {
        super(name);
        this.setPassword(password);
    }

    public static void initialize(String name, String password) {
        if (instance != null) {
            throw new IllegalStateException("Librarian is already initialized.");
        }
        instance = new Librarian(name, password);
    }

    public static Librarian getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Librarian has not been initialized yet.");
        }
        return instance;
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
