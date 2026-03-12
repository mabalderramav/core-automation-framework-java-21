package com.miasoftnanus.automation.core.environment.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Represents an environment's API configuration consisting of a name and a list of APIs.
 * <p>
 * This class provides a structured representation of APIs within a particular
 * environment. It encapsulates the environment's name and the associated APIs,
 * allowing for the management of API configurations in a standardized manner.
 * </p>
 */
@Data
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
public class EnvironmentApi extends Environment {
    private List<Api> apis;

    /**
     * Initializes a new instance of the EnvironmentApi class with default values.
     * <p>
     * The default constructor sets the name to an empty string and initializes
     * the list of APIs as an empty, immutable list.
     */
    public EnvironmentApi() {
        super();
        this.apis = List.of();
    }
}
