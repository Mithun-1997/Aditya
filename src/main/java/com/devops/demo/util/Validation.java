package com.devops.demo.util;

import com.devops.demo.model.User;

public class Validation {
    public static boolean validatePasswordMatch(User user) {
        return user.getPassword().equals(user.getValidatePassword());
    }
}
