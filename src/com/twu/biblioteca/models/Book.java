package com.twu.biblioteca.models;

public class Book {

    private String name;
    private String author;
    private String year;
    private String checked;

    public Book(String name, String author, String year, String checked) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.checked = checked;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getYear() {
        return this.year;
    }

    public boolean isChecked() { return this.checked != null; }

    public String getCode() { return this.checked; }

    public void checkout(String code) {
        this.checked = code;
        System.out.println("Thank you! Enjoy the book.");
    }

    public void returnBook() {
        this.checked = null;
        System.out.println("Thank you for returning the book.");

    }
}
