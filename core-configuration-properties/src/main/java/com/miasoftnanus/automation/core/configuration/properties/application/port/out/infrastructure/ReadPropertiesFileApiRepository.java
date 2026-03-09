package com.miasoftnanus.automation.core.configuration.properties.application.port.out.infrastructure;

import com.miasoftnanus.automation.core.configuration.properties.model.ApiConfig;

/**
 * Represents a repository interface for reading API-specific properties from a properties file
 * and converting them into an {@code ApiConfig} instance. This interface provides an abstraction
 * for retrieving API configuration settings required for application setup or functionality.
 */
public interface ReadPropertiesFileApiRepository {

    /**
     * Reads the properties file from the specified file path and constructs an {@code ApiConfig} instance
     * populated with API-specific configuration values.
     *
     * @param propertyFilePath the path to the properties file containing API configuration data.
     * @return an instance of {@code ApiConfig} containing the configuration values loaded from the properties file.
     */
    ApiConfig readPropertiesFile(String propertyFilePath);
}
