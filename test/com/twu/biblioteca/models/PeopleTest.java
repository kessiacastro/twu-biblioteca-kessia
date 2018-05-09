package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PeopleTest {

    private People user;
    private People librarian;
    private String name = "Fulano";
    private String email = "fulano@test.com";
    private String address = "Avenida Rebúplica do Líbano, 540. Recife/PE - Brazil";
    private String phone = "123456789";
    private String userType = "user";
    private String librarianType = "librarian";
    private String password = "test";
    private String code = "1234";

    @Before
    public void initialize() {
       this.user = new People(name, email, address, phone, userType, password, code);
       this.librarian = new People(name, email, address, phone, librarianType, password, code);
    }

    @Test
    public void peopleName() {
        assertEquals(name, user.getName());
    }

    @Test
    public void peopleEmail() {
        assertEquals(email, user.getEmail());
    }

    @Test
    public void peopleAddress() {
        assertEquals(address, user.getAddress());
    }

    @Test
    public void peoplePhone() {
        assertEquals(phone, user.getPhone());
    }

    @Test
    public void userType() {
        assertEquals(userType, user.getType());
    }

    @Test
    public void librarian() {
        assertEquals(librarianType, librarian.getType());
    }

    @Test
    public void peoplePassword() {
        assertEquals(password, librarian.getPassword());
    }

    @Test
    public void peopleNumber() {
        assertEquals(code, librarian.getCode());
    }

}