package com.twu.biblioteca;


import com.twu.biblioteca.seeds.Seed;
import com.twu.biblioteca.view.Menu;

public class BibliotecaApp {

    public static void main(String[] args) {
        Seed seed = new Seed();
        Menu menu = new Menu();

        menu.printWelcomeMessage();
        menu.printMenuOptions();


    }
}
