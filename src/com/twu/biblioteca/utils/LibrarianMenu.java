package com.twu.biblioteca.utils;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.People;
import com.twu.biblioteca.models.Repository;
import com.twu.biblioteca.validators.InputValidator;

import java.util.*;

public class LibrarianMenu {

    private Map<String, String> options = new HashMap<String, String>();
    private Map<String, Runnable> commands = new HashMap<String, Runnable>();
    private String booksListLines = "+-----+--------------------------+-----------------+------+---------+%n";
    private String booksListColumnNames = "| Cod | Book name                | Author name     | Year | Checked |%n";
    private Repository repository;
    Scanner scan = new Scanner(System.in);
    private InputValidator validator = new InputValidator();
    private People user;


    public LibrarianMenu(Repository repository, People user) {
        this.user = user;
        this.populateLibrarianMenu();
        this.repository = repository;
    }

    public void populateLibrarianMenu() {
        this.options.put("9", "Quit");
        this.commands.put("9", new Runnable() {
            @Override
            public void run() {
                System.exit(0);
            }
        });

        this.options.put("1", "List all books");
        this.commands.put("1", new Runnable() {
            @Override
            public void run() {
                printBooksList(repository.getBooks());
            }
        });
    }

    public Map<String, String> getOptions() {
        return this.options;
    }

    public void printBooksList(ArrayList<Book> booksList) {
        String leftAlignFormat = "| %-3s | %-24s | %-15s | %-4s | %-7s |%n";
        String columns = this.booksListLines + this.booksListColumnNames + this.booksListLines;

        for (int i=0; i < booksList.size(); i++) {
            Book book = booksList.get(i);
            StringBuilder line = new StringBuilder();
            String code = book.getCode() == null ? "" : book.getCode();
            String formattedString = String.format(leftAlignFormat, Integer.toString(i), book.getName(), book.getAuthor(), book.getYear(), code);
            line.append(formattedString);
            columns += line;
        }
        columns += this.booksListLines;
        System.out.format(columns);
    }

    public void showMenu() {
        boolean isValidOption;
        String option;
        boolean repeatMenu = true;
        while(repeatMenu){
            this.printMenuOptions();
            this.chooseOption();
            option = scan.next();
            isValidOption = validator.validadeMenuInput(option, this.getOptions());

            if(isValidOption) {
                commands.get(option).run();
            } else {
                System.out.println("Select a valid option!\n");
            }
        }
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

    public void chooseOption() {
        System.out.println("Choose an option: ");
    }
}
