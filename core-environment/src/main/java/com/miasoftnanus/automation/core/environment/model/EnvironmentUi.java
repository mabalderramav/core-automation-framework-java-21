package com.miasoftnanus.automation.core.environment.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Represents an environment's user interface configuration consisting of a name and associated portals.
 * <p>
 * This class is part of the environment model and provides a structured way to represent
 * the user interface aspects of an environment. It encapsulates the environment's name
 * and a list of related portals, allowing for organized access to portal-specific details.
 */
@Data
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
public class EnvironmentUi extends Environment {
    private List<Portal> portals;

    /**
     * Initializes a new instance of the EnvironmentUi class with default values.
     * <p>
     * The default constructor sets the name to an empty string
     * and initializes the portals list as an empty, immutable list.
     * </p>
     */
    public EnvironmentUi() {
        super();
        this.portals = List.of();
    }
}
