package com.library.models;

import java.util.Objects;
import java.util.UUID;

public abstract class Person {
    private final String id;
    private String name;

    public abstract void whoYouAre();

    public Person(String name) {
        this.id = UUID.randomUUID().toString();
        this.setName(name);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person {" +
                "\n id = " + id +
                "\n name = " + name +
                "\n}\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return person.id.equals(id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
