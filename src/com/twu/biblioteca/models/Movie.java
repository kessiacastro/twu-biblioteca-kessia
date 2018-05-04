package com.twu.biblioteca.models;

public class Movie {

    private String name;
    private String year;
    private String director;
    private int rating = 0;
    private boolean isChecked = false;

    public Movie(String name, String year, String director, int rating, boolean isChecked) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.isChecked = isChecked;
    }

    public String getName() {
        return this.name;
    }

    public String getYear() {
        return this.year;
    }

    public String getDirector() {
        return this.director;
    }

    public int getRating() {
        return this.rating;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void checkout() {
        this.isChecked = true;
        System.out.println("Thank you! Enjoy the movie.");
    }

    public void returnMovie() {
        this.isChecked = false;
        System.out.println("Thank you for returning the movie.");
    }
}
