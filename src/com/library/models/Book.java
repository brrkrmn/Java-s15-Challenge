package com.library.models;

import java.util.Objects;
import java.util.UUID;

public class Book {
    private final String id;
    private Author author;
    private String title;
    private final int price = 1;
    private BookStatus status;
    private int edition;
    private String dateOfPurchase;
    private BookCategory category;
    private Reader reader;
    private Reader owner;

    public Book(Author author, String title, int edition, BookCategory category) {
        this.id = UUID.randomUUID().toString();
        this.status = BookStatus.AVAILABLE;
        this.author = author;
        this.title = title;
        this.edition = edition;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public BookStatus getStatus() {
        return status;
    }

    public int getEdition() {
        return edition;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public BookCategory getCategory() {
        return category;
    }

    public Reader getOwner() {
        return owner;
    }

    public Reader getReader() {
        return reader;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public void setOwner(Reader owner) {
        this.owner = owner;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", edition=" + edition +
                ", dateOfPurchase='" + dateOfPurchase + '\'' +
                ", category=" + category +
                ", reader=" + reader +
                ", owner=" + owner +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return book.id.equals(id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

