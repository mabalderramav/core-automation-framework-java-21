package com.miasoftnanus.automation.core.environment.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Represents a portal containing information such as its name, login URL, base URL, and associated users.
 * <p>
 * The Portal class is part of the environment model and provides a way to encapsulate
 * the details of a portal, including its connection points and relevant user configurations.
 * </p>
 */
@Data
@Accessors(fluent = true)
public class Portal {
    private String name;
    private String loginUrl;
    private String baseUrl;
    private List<User> users;

    /**
     * Initializes an instance of {@link Portal}.
     */
    public Portal() {
        this.users = List.of();
        this.name = ReservedWords.EMPTY_STRING.val();
        this.loginUrl = ReservedWords.EMPTY_STRING.val();
        this.baseUrl = ReservedWords.EMPTY_STRING.val();
    }
}
