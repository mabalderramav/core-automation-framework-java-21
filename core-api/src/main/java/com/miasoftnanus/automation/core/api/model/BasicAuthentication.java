package com.miasoftnanus.automation.core.api.model;

import java.util.Objects;

/**
 * Represents basic authentication credentials with a username and a password.
 * <p>
 * This record enforces the following validation rules:
 * - The `username` must not be null or empty.
 * - The `password` must not be null or empty.
 * </p>
 * Once an instance is created, its fields are immutable, making it inherently thread-safe.
 *
 * @param username the username for authentication; must not be null or empty.
 * @param password the password for authentication; must not be null or empty.
 */
public record BasicAuthentication(String username, String password) {
    /**
     * Constructs an instance of {@code BasicAuthentication}.
     *
     * @param username the username for authentication; must not be null or empty.
     * @param password the password for authentication; must not be null or empty.
     * @throws NullPointerException     if {@code username} or {@code password} is null.
     * @throws IllegalArgumentException if {@code username} or {@code password} is empty.
     */
    public BasicAuthentication {
        Objects.requireNonNull(username, "'username' must not be null");
        Objects.requireNonNull(password, "'password' must not be null");
        if (username.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("'username or password' must not be empty");
        }
    }
}
