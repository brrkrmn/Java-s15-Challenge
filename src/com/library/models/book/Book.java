package com.library.models.book;

import com.library.models.person.Author;
import com.library.models.person.Reader;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Book {
    private final String id;
    private Author author;
    private String title;
    private int price = 1;
    private BookStatus status;
    private int year;
    private LocalDate dateOfPurchase;
    private BookCategory category;
    private Reader reader;
    private Reader owner;

    public Book(Author author, String title, int year, BookCategory category) {
        this.id = UUID.randomUUID().toString();
        this.setStatus(BookStatus.AVAILABLE);
        this.setAuthor(author);
        this.setTitle(title);
        this.setYear(year);
        this.setCategory(category);
        author.getBooks().put(id, this);
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

    public int getYear() {
        return year;
    }

    public LocalDate getDateOfPurchase() {
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

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public void setYear(int year) {
        this.year = year;
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

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\n\n== BOOK ================================" +
                "\n     id = " + id +
                "\n     title = " + title +
                "\n     author = " + author.getName() +
                "\n     year = " + year +
                "\n     price = " + price +
                "\n     status = " + status +
                "\n     category = " + category +
                "\n     reader = " + (reader == null ? "null" : reader.getName()) +
                "\n     owner = " + (owner == null ? "null" : owner.getName()) +
                "\n     dateOfPurchase = " + dateOfPurchase +
                "\n=========================================";
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

