package com.miasoftnanus.automation.core.configuration.properties.adapter.in.controller;

import com.miasoftnanus.automation.core.configuration.properties.application.port.in.ReadPropertiesFileApiUseCase;
import com.miasoftnanus.automation.core.configuration.properties.model.ApiConfig;
import lombok.RequiredArgsConstructor;

/**
 * Controller class responsible for handling the operation of reading a properties file and
 * getting API configuration details. This class delegates the execution of the use case
 * to an instance of {@link ReadPropertiesFileApiUseCase}.
 * <p>
 * The primary purpose of this controller is to facilitate the reading of environment-specific
 * properties files and return an {@link ApiConfig} object that contains the configuration
 * details necessary for API-level functionalities.
 * </p>
 * <p>
 * This class is designed to serve as the intermediary layer between the application layer
 * and the business logic encapsulated in the use case.
 * </p>
 */
@RequiredArgsConstructor
public class ReadPropertiesFileApiController {
    private final ReadPropertiesFileApiUseCase readPropertiesFileApiUseCase;

    /**
     * Reads the specified properties file and retrieves its content as an {@link ApiConfig} object.
     * This method delegates the operation to a use case responsible for processing the file and
     * extracting API-related configuration details.
     *
     * @param propertyFilePath the file path of the environment-specific properties file to be read.
     *                         This file is expected to contain the configuration settings required
     *                         for the API environment setup.
     * @return an {@link ApiConfig} object containing the extracted configuration details such as
     * API name, version, authentication type, and user type necessary for API-related
     * functionalities.
     */
    public ApiConfig readPropertiesFile(String propertyFilePath) {
        return readPropertiesFileApiUseCase.readPropertiesFile(propertyFilePath);
    }
}
