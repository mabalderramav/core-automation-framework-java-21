package com.miasoftnanus.automation.core.environment.model;

import lombok.Data;
import lombok.experimental.Accessors;

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
public abstract class Environment {

    protected String name;

    /**
     * Initializes an instance of {@link Environment}.
     */
    protected Environment() {
        this.name = ReservedWords.EMPTY_STRING.val();
    }
}
