package com.miasoftnanus.automation.core.configuration.properties.adapter.in.controller;

import com.miasoftnanus.automation.core.configuration.properties.application.port.in.ReadPropertiesFileUiUseCase;
import com.miasoftnanus.automation.core.configuration.properties.application.service.ReadPropertiesFileUiService;
import com.miasoftnanus.automation.core.configuration.properties.model.UiConfig;
import lombok.RequiredArgsConstructor;

/**
 * Controller class responsible for managing the operation of reading a properties file
 * and retrieving UI configuration settings. This class delegates the actual task of reading
 * and processing the file to an instance of {@link ReadPropertiesFileUiService}.
 * <p>
 * The primary purpose of this controller is to act as the intermediary layer between
 * the user interface logic and the underlying service layer. It simplifies the process
 * of getting environment-specific configuration settings required for the UI layer
 * of the application.
 * </p>
 */
@RequiredArgsConstructor
public class ReadPropertiesFileUiController {
    private final ReadPropertiesFileUiUseCase readPropertiesFileUiUseCase;

    /**
     * Reads the specified environment properties file and retrieves its content as a {@link UiConfig} object.
     * This method delegates the operation to the underlying service responsible for processing the file.
     *
     * @param propertyFilePath the file path of the environment-specific properties file to be read.
     *                         This file is expected to contain the configuration settings required for
     *                         the UI environment setup.
     * @return a {@link UiConfig} object containing the extracted configuration details such as browser settings,
     * timeouts, dimensions, and other UI-specific properties necessary for the application's runtime environment.
     */
    public UiConfig readPropertiesFile(String propertyFilePath) {
        return readPropertiesFileUiUseCase.readPropertiesFile(propertyFilePath);
    }
}
