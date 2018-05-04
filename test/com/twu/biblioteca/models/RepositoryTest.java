package com.twu.biblioteca.models;

import com.twu.biblioteca.seeds.Seed;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RepositoryTest {

    private Seed seed;
    private Repository repo;

    @Before
    public void initialize() {
        seed = new Seed();
        repo = new Repository(seed.getBooksList(), seed.getMoviesList());
    }

    @Test
    public void repositoryBooksNotEmpty() {
        assertEquals(5, repo.getBooks().size());
    }

    @Test
    public void repositoryMoviesNotEmpty() { assertEquals(5, repo.getBooks().size()); }

}