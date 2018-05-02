package com.twu.biblioteca.controller;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Repository;
import com.twu.biblioteca.seeds.Seed;
import com.twu.biblioteca.validators.InputValidator;

import java.lang.reflect.Method;
import java.util.*;

public class StartApp {

    private String welcomeMessage = "| Welcome to TWU-Library |%n";
    private String welcomeLines = "+------------------------+%n";
    private String listLines = "+-----+--------------------------+-----------------+------+%n";
    private String listColumnNames = "| Cod | Book name                | Author name     | Year |%n";
    private Map<String, String> options = new HashMap<String, String>();
    Map<String, Runnable> commands = new HashMap<String, Runnable>();
    Seed seed = new Seed();
    private Repository bookslist= new Repository(seed.getBooksList());
    private InputValidator validator;
    boolean isValidOption = false;
    Scanner scan;

    public StartApp() {
        this.populateMenuOptions();
        validator = new InputValidator();
        scan = new Scanner(System.in);
        this.printWelcomeMessage();
        this.showMenu();
    }

    public void populateMenuOptions() {
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
                printBooksList(bookslist.getBooks());
            }
        });

        this.options.put("2", "Checkout book");
        this.commands.put("2", new Runnable() {
            @Override
            public void run() {
                checkoutBook();
            }
        });

        this.options.put("3", "Return a book");
        this.commands.put("3", new Runnable() {
            @Override
            public void run() {
                returnBook();
            }
        });
    }

    public void printWelcomeMessage() {
        String message = this.welcomeLines + this.welcomeMessage + this.welcomeLines;
        System.out.format(message);
    }

    public Map<String, String> getOptions() {
        return this.options;
    }

    public void printBooksList(ArrayList<Book> booksList) {
        String leftAlignFormat = "| %-3s | %-24s | %-15s | %-4s |%n";
        String columns = this.listLines + this.listColumnNames + this.listLines;

        for (int i=0; i < booksList.size(); i++) {
            Book book = booksList.get(i);
            if (!book.isChecked()) {
                StringBuilder line = new StringBuilder();
                String formattedString = String.format(leftAlignFormat, Integer.toString(i), book.getName(), book.getAuthor(), book.getYear());
                line.append(formattedString);
                columns += line;
            }
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

    public void chooseOption() {
        System.out.println("Choose an option: ");
    }

    public void chooseBook() {
        System.out.println("Type the book code or 'b' for back: ");
    }

    public void showMenu() {
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

    public void checkoutBook() {
        this.subMenu("checkoutBook");
    }

    public void returnBook() {
        this.subMenu("returnBook");
    }

    public void subMenu(String action) {
        boolean repeatMenu = true;
        boolean validCode;
        while(repeatMenu){
            this.chooseBook();
            String code = this.getCode();
            if (code.equals("b")) {
                repeatMenu = false;
            } else {
                validCode = Integer.parseInt(code) < bookslist.getBooks().size();
                if(validCode && Integer.parseInt(code) >= 0) {
                    Book book = this.bookslist.getBooks().get(Integer.parseInt(code));
                    if (action == "returnBook") {
                        if(book.isChecked()) {
                            book.returnBook();
                            repeatMenu = false;
                        } else {
                            System.out.println("This book was not checked. Try another one.");
                        }
                    }
                    if (action == "checkoutBook") {
                        if (!book.isChecked()) {
                            book.checkout();
                            repeatMenu = false;
                        } else {
                            System.out.println("This book is already checked. Try another one.");
                        }
                    }
                } else {
                    System.out.println("That is not a valid code.\n");
                }
            }
        }
    }

    public String getCode () {
        String code;
        code = scan.next();
        return code;
    }
}
