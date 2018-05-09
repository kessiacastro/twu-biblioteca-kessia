package com.twu.biblioteca.controller;

import com.twu.biblioteca.models.People;
import com.twu.biblioteca.models.Repository;
import com.twu.biblioteca.seeds.Seed;
import com.twu.biblioteca.utils.LibrarianMenu;
import com.twu.biblioteca.utils.UserMenu;
import com.twu.biblioteca.validators.Auth;
import com.twu.biblioteca.validators.InputValidator;

import java.util.*;

public class StartApp {

    Seed seed = new Seed();
    Auth auth = new Auth();
    private String welcomeMessage = "| Welcome to TWU-Library |%n";
    private String welcomeLines = "+------------------------+%n";
    private Repository repository = new Repository(seed.getBooksList(), seed.getMoviesList());
    private UserMenu usermenu;
    private LibrarianMenu librarianMenu;

    Scanner scan = new Scanner(System.in);

    public StartApp() {
        this.printWelcomeMessage();
        this.showAuthMenu();
    }

    private void showAuthMenu() {
        String code;
        String password;
        boolean repeatMenu = true;
        while(repeatMenu){
            System.out.println("Insert your library code:");
            code = scan.next();

            System.out.println("Insert your password");
            password = scan.next();
            People user = auth.validateUser(code, password, seed.getUsersList());
            if (user == null) {
                System.out.println("Invalid credentials!\n");
            } else {
                this.showMenu(user);
                repeatMenu = false;
            }
        }

    }


    public void printWelcomeMessage() {
        String message = this.welcomeLines + this.welcomeMessage + this.welcomeLines;
        System.out.format(message);
    }


    public void showMenu(People user) {
       if (user.getType().equals("librarian")) {
           this.librarianMenu = new LibrarianMenu(repository, user);
           this.librarianMenu.showMenu();
       }

       if (user.getType().equals("user")) {
           this.usermenu = new UserMenu(repository, user);
           this.usermenu.showMenu();
       }
    }


}
