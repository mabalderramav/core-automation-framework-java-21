package com.miasoftnanus.automation.core.configuration.properties.application.port.in;

import com.miasoftnanus.automation.core.configuration.properties.model.ApiConfig;

/**
 * Represents a use case for reading a properties file and converting its content
 * into an {@link ApiConfig} object. This is specifically designed to handle
 * configuration settings required for API-related functionalities within an application.
 *
 * The implementation of this interface is expected to parse the provided properties
 * file, extract the relevant API configuration details, and return an instance of
 * {@link ApiConfig} containing these settings.
 *
 * This use case is useful in scenarios where environment-specific or dynamic API
 * configurations need to be loaded at runtime.
 */
public interface ReadPropertiesFileApiUseCase {

    /**
     * Reads the provided properties file and converts its content into an {@link ApiConfig} object.
     * This method is used to load configuration settings specific to an API environment.
     *
     * @param propertyFilePath the file path of the environment-specific properties file to be read.
     * @return an instance of {@link ApiConfig} containing the configuration details loaded from the properties file.
     */
    ApiConfig readPropertiesFile(String propertyFilePath);
}
