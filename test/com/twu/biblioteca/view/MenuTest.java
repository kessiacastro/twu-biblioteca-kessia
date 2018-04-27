package com.twu.biblioteca.view;

import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void welcomeMessage() {
        Menu menu = new Menu();
        String message = "Welcome to the TWU-Library";
        assertEquals(message, menu.welcomeMessage());
    }

}