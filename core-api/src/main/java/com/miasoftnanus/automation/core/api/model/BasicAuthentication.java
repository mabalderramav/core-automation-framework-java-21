package com.miasoftnanus.automation.core.api.model;

import java.util.Objects;

public record BasicAuthentication(String username, String password) {
    public BasicAuthentication {
        Objects.requireNonNull(username, "'username' must not be null");
        Objects.requireNonNull(password, "'password' must not be null");
        if (username.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("'username or password' must not be empty");
        }
    }
}
