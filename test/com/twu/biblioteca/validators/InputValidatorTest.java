package com.twu.biblioteca.validators;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import com.twu.biblioteca.controller.StartApp;


public class InputValidatorTest {

    StartApp startApp;

    @Before
    public void initialize() {
        startApp = new StartApp();
    }

    @Test
    public void menuInputIsValid() {
        assertEquals(true, InputValidator.validadeMenuInput("1", startApp.getOptions()));
    }

    @Test
    public void menuInputIsNotValid() {
        assertEquals(false, InputValidator.validadeMenuInput("Not Valid", startApp.getOptions()));
    }

    @Test
    public void menuInputIsEmpty() {
        assertEquals(false, InputValidator.validadeMenuInput("", startApp.getOptions()));
    }

    @Test
    public void menuInputIsOutOfOptions() {
        assertEquals(false, InputValidator.validadeMenuInput("10", startApp.getOptions()));
    }
}