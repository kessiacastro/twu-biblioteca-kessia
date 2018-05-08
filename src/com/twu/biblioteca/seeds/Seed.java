package com.twu.biblioteca.seeds;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.People;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Seed {
    private ArrayList<Book> bookList = new ArrayList<>();
    private ArrayList<Movie> movieList = new ArrayList<>();
    private ArrayList<People> userList = new ArrayList<>();

    public Seed () {
        this.bookList = this.populateList();
        this.movieList = this.populateMovies();
        this.userList = this.populateUsers();
    }

    public ArrayList<Book> getBooksList() {
        return this.bookList;
    }
    public ArrayList<Movie> getMoviesList() { return this.movieList; }
    public ArrayList<People> getUsersList() { return this.userList; }

    public ArrayList<Book> populateList() {
        File file = new File("src/booksList.txt");
        ArrayList<Book> list = new ArrayList<>();

        try {

            Scanner sc = new Scanner(file);
            sc.useDelimiter("\\n");

            while (sc.hasNextLine()) {
                String[] lineInfo = sc.nextLine().split(";");
                Book newBook = new Book(lineInfo[0], lineInfo[1], lineInfo[2], Boolean.parseBoolean(lineInfo[3]));
                list.add(newBook);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Movie> populateMovies() {
        File file = new File("src/moviesList.txt");
        ArrayList<Movie> list = new ArrayList<>();

        try {

            Scanner sc = new Scanner(file);
            sc.useDelimiter("\\n");

            while (sc.hasNextLine()) {
                String[] lineInfo = sc.nextLine().split(";");
                Movie newMovie = new Movie(lineInfo[0], lineInfo[1], lineInfo[2], Integer.parseInt(lineInfo[3]), Boolean.parseBoolean(lineInfo[3]));
                list.add(newMovie);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<People> populateUsers() {
        File file = new File("src/userList.txt");
        ArrayList<People> list = new ArrayList<>();

        try {

            Scanner sc = new Scanner(file);
            sc.useDelimiter("\\n");

            while (sc.hasNextLine()) {
                String[] lineInfo = sc.nextLine().split(";");
                People newUser = new People(lineInfo[0], lineInfo[1], lineInfo[2], lineInfo[3], lineInfo[4], lineInfo[5]);
                list.add(newUser);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }
}
