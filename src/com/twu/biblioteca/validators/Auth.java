package com.twu.biblioteca.validators;

import com.twu.biblioteca.models.People;

import java.util.ArrayList;

public class Auth {

    public static People validateUser(String email, String password, ArrayList<People> userList) {
        for(People user : userList) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
