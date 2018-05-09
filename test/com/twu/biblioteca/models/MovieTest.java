package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    private Movie movie;
    private String name = "A Lagoa Azul";
    private String year = "2000";
    private String director = "Fulano de Tal";
    private int rating = 0;
    private String checked = null;
    private String code = "1234";

    @Before
    public void initialize() {
        movie = new Movie(name, year, director, rating, checked);
    }

    @Test
    public void movieName() {
        assertEquals(name, movie.getName());
    }

    @Test
    public void movieYear() {
        assertEquals(year, movie.getYear());
    }

    @Test
    public void movieDirector() {
        assertEquals(director, movie.getDirector());
    }

    @Test
    public void movieRating() {
        assertEquals(rating, movie.getRating());
    }

    @Test
    public void availability() {
        assertEquals(false, movie.isChecked());
    }

    @Test
    public void checkoutMovie() {
        movie.checkout(code);
        assertEquals(code, movie.getCode());
    }

    @Test
    public void returnMovie() {
        movie.returnMovie();
        assertEquals(false, movie.isChecked());
    }
}