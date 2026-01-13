package com.miasoftnanus.automation.core.environment.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Represents an authentication mechanism used within the system.
 * <p>
 * This class encapsulates the details regarding the authentication type
 * and the associated users for the authentication mechanism. It allows
 * defining the type of authentication (e.g., key-based, token-based)
 * and provides a list of users that correspond to this mechanism.
 * </p>
 */
@Data
@Accessors(fluent = true)
public class Authentication {
    private String type;
    private List<User> users;

    /**
     * Initializes an instance of {@link Authentication}.
     */
    public Authentication() {
        this.users = List.of();
        this.type = ReservedWords.EMPTY_STRING.val();
    }
}
