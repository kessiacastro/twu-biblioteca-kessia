package com.twu.biblioteca.utils;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.People;
import com.twu.biblioteca.models.Repository;
import com.twu.biblioteca.validators.Auth;
import com.twu.biblioteca.validators.InputValidator;

import java.util.*;

public class UserMenu {

    private Map<String, String> options = new HashMap<String, String>();
    private Map<String, Runnable> commands = new HashMap<String, Runnable>();
    private String booksListLines = "+-----+--------------------------+-----------------+------+%n";
    private String moviesListLines ="+-----+--------------------------+-----------------+------+------+%n";
    private String booksListColumnNames = "| Cod | Book name                | Author name     | Year |%n";
    private String moviesListColumnNames = "| Cod | Movie title              | Director        | Year | Rate |%n";
    private String userInfoLines = "+------+--------------------------+-----------------+-----------+%n";
    private String userInfo = "| Code | Name                     | Email           | Phone     |%n";
    private Repository repository;
    Scanner scan = new Scanner(System.in);
    private InputValidator validator = new InputValidator();
    private People user;

    public UserMenu(Repository repository, People user) {
        this.user = user;
        this.populateUserMenu();
        this.repository = repository;
    }

    public void populateUserMenu() {
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

        this.options.put("4", "List all movies");
        this.commands.put("4", new Runnable() {
            @Override
            public void run() {
                printMoviesList(repository.getMovies());
            }
        });

        this.options.put("5", "Checkout Movie");
        this.commands.put("5", new Runnable() {
            @Override
            public void run() {
                checkoutMovie();
            }
        });

        this.options.put("6", "User Info");
        this.commands.put("6", new Runnable() {
            @Override
            public void run() {
                showUserInfo();
            }
        });
    }

    public void printBooksList(ArrayList<Book> booksList) {
        String leftAlignFormat = "| %-3s | %-24s | %-15s | %-4s |%n";
        String columns = this.booksListLines + this.booksListColumnNames + this.booksListLines;

        for (int i=0; i < booksList.size(); i++) {
            Book book = booksList.get(i);
            if (!book.isChecked()) {
                StringBuilder line = new StringBuilder();
                String formattedString = String.format(leftAlignFormat, Integer.toString(i), book.getName(), book.getAuthor(), book.getYear());
                line.append(formattedString);
                columns += line;
            }
        }

        columns += this.booksListLines;
        System.out.format(columns);
    }

    public void printMoviesList(ArrayList<Movie> moviesList) {
        String leftAlignFormat = "| %-3s | %-24s | %-15s | %-4s | %-4s |%n";
        String columns = this.moviesListLines + this.moviesListColumnNames + this.moviesListLines;

        for (int i=0; i < moviesList.size(); i++) {
            Movie movie = moviesList.get(i);
            if (!movie.isChecked()) {
                StringBuilder line = new StringBuilder();
                String formattedString = String.format(leftAlignFormat, Integer.toString(i), movie.getName(), movie.getDirector(), movie.getYear(), movie.getRating());
                line.append(formattedString);
                columns += line;
            }
        }

        columns += this.moviesListLines;
        System.out.format(columns);
    }

    public void showUserInfo() {
        String leftAlignFormat = "| %-4s | %-24s | %-15s | %-8s |%n";
        String columns = this.userInfoLines + this.userInfo + this.userInfoLines;
        StringBuilder line = new StringBuilder();
        String formattedString = String.format(leftAlignFormat, this.user.getCode(), this.user.getName(), this.user.getEmail(), this.user.getPhone());
        line.append(formattedString);
        columns += line;
        columns += this.userInfoLines;
        System.out.format(columns);
    }


    public void checkoutBook() {
        this.subMenu("checkoutBook", "This book is already checked. Try another one.");
    }

    public void returnBook() {
        this.subMenu("returnBook", "This book was not checked. Try another one.");
    }

    public void checkoutMovie() {
        this.subMenu("checkoutMovie", "This movie is already checked. Try another one.");
    }

    public void subMenu(String action, String message) {
        boolean repeatMenu = true;
        boolean validCode;
        while(repeatMenu){
            this.chooseCode();
            String code = this.getCode();
            if (code.equals("b")) {
                repeatMenu = false;
            } else {
                validCode = Integer.parseInt(code) < repository.getBooks().size();
                if(validCode && Integer.parseInt(code) >= 0) {
                    if (action.equals("checkoutMovie")) {
                        Movie movie = this.repository.getMovies().get(Integer.parseInt(code));
                        if (!movie.isChecked()) {
                            movie.checkout(this.user.getCode());
                            repeatMenu = false;
                        } else {
                            System.out.println(message);
                        }
                    }
                    if (action.equals("returnBook")) {
                        Book book = this.repository.getBooks().get(Integer.parseInt(code));
                        if(book.isChecked()) {
                            book.returnBook();
                            repeatMenu = false;
                        } else {
                            System.out.println(message);
                        }
                    }
                    if (action.equals("checkoutBook")) {
                        Book book = this.repository.getBooks().get(Integer.parseInt(code));
                        if (!book.isChecked()) {
                            book.checkout(this.user.getCode());
                            repeatMenu = false;
                        } else {
                            System.out.println(message);
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

    public void chooseCode() {
        System.out.println("Type the item code or 'b' for back: ");
    }

    public Map<String, String> getOptions() {
        return this.options;
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


}
