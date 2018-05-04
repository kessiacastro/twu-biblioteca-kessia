package com.twu.biblioteca.models;

import com.twu.biblioteca.seeds.Seed;

import java.util.ArrayList;

public class Repository {

    private ArrayList<Book> books;
    private ArrayList<Movie> movies;

    public Repository (ArrayList<Book> bookSeeds, ArrayList<Movie> moviesSeeds) {
        this.books = bookSeeds;
        this.movies = moviesSeeds;
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public ArrayList<Movie> getMovies() { return this.movies; }
}
