package com.twu.biblioteca.seeds;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Seed {
    private ArrayList<Book> bookList = new ArrayList<Book>();

    public Seed () {
        this.bookList = this.populateList();
    }

    public ArrayList<Book> getBooksList() {
        return bookList;
    }

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

    public ArrayList<Movie> getMoviesList() {
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
}
