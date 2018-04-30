package com.twu.biblioteca.models;

public class Book {

    private String name;
    private String author;
    private String year;
    private boolean checked;

    public Book(String name, String author, String year, boolean checked) {
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

    public boolean isChecked() {
        return checked;
    }

    public void checkout() {
        this.checked = true;
    }
}
