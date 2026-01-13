package com.miasoftnanus.automation.core.environment.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Represents an environment containing a collection of portals and APIs.
 * <p>
 * This class provides a framework for organizing and managing the structure
 * and attributes of an environment. Each environment has a name, a list of
 * associated portals, and a list of APIs.
 * </p>
 */
@Data
@Accessors(fluent = true)
public class Environment {

    private String name;
    private List<Portal> portals;
    private List<Api> apis;

    /**
     * Initializes an instance of {@link Environment}.
     */
    public Environment() {
        this.name = ReservedWords.EMPTY_STRING.val();
        this.portals = List.of();
        this.apis = List.of();
    }
}
