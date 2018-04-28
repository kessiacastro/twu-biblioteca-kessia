package com.twu.biblioteca.validators;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import com.twu.biblioteca.view.Menu;


public class InputValidatorTest {

    Menu menu;

    @Before
    public void initialize() {
        menu = new Menu();
    }

    @Test
    public void menuInputIsValid() {
        assertEquals(true, InputValidator.validadeMenuInput("1", menu.getOptions()));
    }

    @Test
    public void menuInputIsNotValid() {
        assertEquals(false, InputValidator.validadeMenuInput("Not Valid", menu.getOptions()));
    }

    @Test
    public void menuInputIsEmpty() {
        assertEquals(false, InputValidator.validadeMenuInput("", menu.getOptions()));
    }

    @Test
    public void menuInputIsOutOfOptions() {
        assertEquals(false, InputValidator.validadeMenuInput("10", menu.getOptions()));
    }
}