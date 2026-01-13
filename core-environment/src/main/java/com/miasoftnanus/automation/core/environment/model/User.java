package com.miasoftnanus.automation.core.environment.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Represents a user with details such as type, username, password, and token.
 * <p>
 * This class provides a structure for defining a user's attributes, enabling
 * the organization and manipulation of user-related information in the system.
 * </p>
 */
@Data
@Accessors(fluent = true)
public class User {
    private String type;
    private String username;
    private String password;
    private String token;

    /**
     * Initializes an instance of {@link User}.
     */
    public User() {
        this.type = ReservedWords.EMPTY_STRING.val();
        this.username = ReservedWords.EMPTY_STRING.val();
        this.password = ReservedWords.EMPTY_STRING.val();
        this.token = ReservedWords.EMPTY_STRING.val();
    }
}
