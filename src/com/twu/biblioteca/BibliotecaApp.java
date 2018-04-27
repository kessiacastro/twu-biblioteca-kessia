package com.twu.biblioteca;


import com.twu.biblioteca.seeds.Seed;
import com.twu.biblioteca.view.Menu;

public class BibliotecaApp {

    public static void main(String[] args) {
        Menu menu = new Menu();
        System.out.println(menu.welcomeMessage());

        Seed seed = new Seed();
        System.out.println(seed.getBooksList().size());
    }
}
