package com.twu.biblioteca.models;

public class Movie {

    private String name;
    private String year;
    private String director;
    private int rating = 0;
    private String checked;

    public Movie(String name, String year, String director, int rating, String checked) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.checked = checked;
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
        return this.checked != null;
    }

    public void checkout(String code) {
        this.checked = code;
        System.out.println("Thank you! Enjoy the movie.");
    }

    public void returnMovie() {
        this.checked = null;
        System.out.println("Thank you for returning the movie.");
    }

    public String getCode() {
        return this.checked;
    }
}
