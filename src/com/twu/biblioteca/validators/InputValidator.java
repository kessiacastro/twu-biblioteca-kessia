package com.twu.biblioteca.validators;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InputValidator {

    public static boolean validadeMenuInput(String option, Map<String, String> menuOptions) {
        return Arrays.asList(menuOptions.keySet().toArray()).contains(option);
    }
}
