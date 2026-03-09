package com.miasoftnanus.automation.core.configuration.properties.application.port.out.infrastructure;

import com.miasoftnanus.automation.core.configuration.properties.model.UiConfig;

/**
 * Represents a repository interface for reading UI-specific properties from a properties file
 * and converting them into a {@code UiConfig} instance. This interface serves as an abstraction
 * for retrieving UI configuration settings required for application setup or functionality.
 */
public interface ReadPropertiesFileUiRepository {

    /**
     * Reads the properties file from the specified file path and constructs a {@code UiConfig} instance
     * populated with configuration values.
     *
     * @param propertyFilePath the path to the properties file containing UI configuration data.
     * @return an instance of {@code UiConfig} containing the configuration values loaded from the properties file.
     */
    UiConfig readPropertiesFile(String propertyFilePath);
}
