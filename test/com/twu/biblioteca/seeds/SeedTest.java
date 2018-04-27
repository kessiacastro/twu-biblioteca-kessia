package com.twu.biblioteca.seeds;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SeedTest {

    private Seed seed;

    @Before
    public void initialize() {
        seed = new Seed();
    }

    @Test
    public void booksListNotEmpty() {
        assertEquals(5, seed.getBooksList().size());
    }
}