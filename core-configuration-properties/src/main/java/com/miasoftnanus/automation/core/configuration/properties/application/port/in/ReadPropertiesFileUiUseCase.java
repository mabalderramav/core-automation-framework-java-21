package com.miasoftnanus.automation.core.configuration.properties.application.port.in;

import com.miasoftnanus.automation.core.configuration.properties.model.UiConfig;

/**
 * Represents a use case for reading a properties file and converting its content
 * into a {@link UiConfig} object. This is specifically designed to handle the
 * configuration settings required for the user interface layer of the application.
 * <p>
 * The implementation of this interface is expected to parse the provided properties
 * file, extract the relevant UI configuration details, and return an instance of
 * {@link UiConfig} containing these settings.
 * </p>
 * <p>
 * This use case is helpful in scenarios where environment-specific or user-defined
 * configurations need to be dynamically loaded at runtime for the UI layer.
 * </p>
 */
public interface ReadPropertiesFileUiUseCase {

    /**
     * Reads the provided properties file and returns a {@link UiConfig} instance
     * representing the configuration settings for the user interface.
     *
     * @param propertyFilePath the file path of the environment-specific properties file.
     * @return an instance of {@link UiConfig} containing the loaded configuration details.
     */
    UiConfig readPropertiesFile(String propertyFilePath);
}
