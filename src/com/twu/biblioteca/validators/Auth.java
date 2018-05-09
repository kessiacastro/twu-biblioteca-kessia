package com.twu.biblioteca.validators;

import com.twu.biblioteca.models.People;

import java.util.ArrayList;

public class Auth {

    public People loggedUser = null;

    public People validateUser(String code, String password, ArrayList<People> userList) {
        for(People user : userList) {
            if(user.getCode().equals(code) && user.getPassword().equals(password)) {
                this.loggedUser = user;
                return user;
            }
        }
        return null;
    }
}
