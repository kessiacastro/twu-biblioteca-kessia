package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    private Book book;
    private String name = "Mindfullness";
    private String author = "Fulano de Tal";
    private String year = "2018";
    private boolean checked = false;

    @Before
    public void initialize() {
        book = new Book(name, author, year, checked);
    }

    @Test
    public void bookName() {
        assertEquals(name, book.getName());
    }

    @Test
    public void authorName() {
        assertEquals(author, book.getAuthor());
    }

    @Test
    public void yearDate() {
        assertEquals(year, book.getYear());
    }

    @Test
    public void availabillity() {
        assertEquals(checked, book.isChecked());
    }
}