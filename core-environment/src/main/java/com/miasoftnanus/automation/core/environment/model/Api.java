package com.miasoftnanus.automation.core.environment.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Represents an API configuration with details such as its name, base URL, available versions, and authentication mechanisms.
 * <p>
 * This class provides a structure for defining an API and its attributes, allowing for
 * the organization of data needed to interact with or describe the API.
 * </p>
 */
@Data
@Accessors(fluent = true)
public class Api {
    private String name;
    private String baseUrl;
    private List<Version> versions;
    private List<Authentication> authentications;

    /**
     * Initializes an instance of {@link Api}.
     */
    public Api() {
        this.versions = List.of();
        this.authentications = List.of();
        this.name = ReservedWords.EMPTY_STRING.val();
        this.baseUrl = ReservedWords.EMPTY_STRING.val();
    }
}
