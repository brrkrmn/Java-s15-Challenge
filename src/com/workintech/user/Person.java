package com.workintech.user;

import java.util.Objects;
import java.util.UUID;

public abstract class Person {
    private final long id;
    private String name;

    public abstract void whoYouAre();

    public Person(String name) {
        this.id = Long.parseLong(UUID.randomUUID().toString());
        this.name = name;
    }

    public long getId() {
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
        return "Person: " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return person.id == id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
