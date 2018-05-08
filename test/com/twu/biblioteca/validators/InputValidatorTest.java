package com.twu.biblioteca.validators;

import com.twu.biblioteca.models.Repository;
import com.twu.biblioteca.seeds.Seed;
import com.twu.biblioteca.utils.UserMenu;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import com.twu.biblioteca.controller.StartApp;


public class InputValidatorTest {

    private Seed seed = new Seed();
    private UserMenu userMenu;
    private Repository repository = new Repository(seed.getBooksList(), seed.getMoviesList());

    @Before
    public void initialize() {
        userMenu = new UserMenu(repository);
    }

    @Test
    public void menuInputIsValid() {
        assertEquals(true, InputValidator.validadeMenuInput("1", userMenu.getOptions()));
    }

    @Test
    public void menuInputIsNotValid() {
        assertEquals(false, InputValidator.validadeMenuInput("Not Valid", userMenu.getOptions()));
    }

    @Test
    public void menuInputIsEmpty() {
        assertEquals(false, InputValidator.validadeMenuInput("", userMenu.getOptions()));
    }

    @Test
    public void menuInputIsOutOfOptions() {
        assertEquals(false, InputValidator.validadeMenuInput("10", userMenu.getOptions()));
    }
}