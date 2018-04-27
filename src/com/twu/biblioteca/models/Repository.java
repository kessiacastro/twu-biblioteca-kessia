package com.twu.biblioteca.models;

import com.twu.biblioteca.seeds.Seed;

import java.util.ArrayList;

public class Repository {

    private ArrayList<Book> books;

    public Repository (ArrayList<Book> seeds) {
        this.books = seeds;
    }


    public ArrayList<Book> getBooks() {
        return this.books;
    }
}
