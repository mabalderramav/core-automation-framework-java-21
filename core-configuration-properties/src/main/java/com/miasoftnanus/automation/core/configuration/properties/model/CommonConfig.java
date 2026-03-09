package com.miasoftnanus.automation.core.configuration.properties.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Represents a common configuration base class to be extended by other configuration classes.
 * This abstract class ensures that the `environmentName` property is predefined and initialized
 * with a default value from the {@link CommonConfigWords} enumeration.
 * <p>
 * The purpose of this class is to serve as a reusable foundation for common configuration
 * attributes within the application's configuration management framework.
 * </p>
 */
@Data
@Accessors(fluent = true)
public abstract class CommonConfig {
    protected String environmentName;
    protected String environmentFilePath;

    /**
     * Constructs a new instance of the CommonConfig class and initializes the `environmentName` property.
     * The `environmentName` is set to the default value retrieved from the {@link CommonConfigWords#ENVIRONMENT_NAME}.
     * This protected constructor is intended to be used by subclasses for ensuring consistent initialization
     * of the common configuration attributes.
     */
    protected CommonConfig() {
        this.environmentName = "";
        this.environmentFilePath = "";
    }
}
