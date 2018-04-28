package com.twu.biblioteca.view;

import com.twu.biblioteca.models.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    private String welcomeMessage = "| Welcome to TWU-Library |%n";
    private String welcomeLines = "+------------------------+%n";
    private String listLines = "+--------------------------+-----------------+------+%n";
    private String listColumnNames = "| Book name                | Author name     | Year |%n";
    private Map<String, String> options = new HashMap<String, String>();

    public Menu() {
        this.populateMenuOptions();
    }

    public void populateMenuOptions() {
        this.options.put("1", "List all books");
    }

    public void printWelcomeMessage() {
        String message = this.welcomeLines + this.welcomeMessage + this.welcomeLines;
        System.out.format(message);
    }

    public Map<String, String> getOptions() {
        return this.options;
    }

    public void printBooksList(ArrayList<Book> booksList) {
        String leftAlignFormat = "| %-24s | %-15s | %-4s |%n";
        String columns = this.listLines + this.listColumnNames + this.listLines;

        for (Book book: booksList) {
            StringBuilder line = new StringBuilder();
            String formattedString = String.format(leftAlignFormat, book.getName(), book.getAuthor(), book.getYear());

            line.append(formattedString);
            columns += line;
        }

        columns += this.listLines;
        System.out.format(columns);
    }

    public void printMenuOptions() {
        String menuOptions = "\nMENU:\n";
        menuOptions += Arrays.toString(options.entrySet().toArray())
                .replace("[", "")
                .replace("]", "")
                .replace("=", " - ")
                .replace(", ", "\n");
        System.out.println(menuOptions);
    }
}
