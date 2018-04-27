package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class RepositoryTest {

    @Test
    public void repositoryNotEmpty() {
        Repository repo = new Repository();
        assertEquals(1, repo.getBooks().size());
    }

}