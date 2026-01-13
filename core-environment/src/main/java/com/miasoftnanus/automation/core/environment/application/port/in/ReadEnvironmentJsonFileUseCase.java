package com.miasoftnanus.automation.core.environment.application.port.in;


import com.miasoftnanus.automation.core.environment.model.Environment;

import java.util.List;

/**
 * Interface for the use case of reading an environment configuration from a JSON file.
 * <p>
 * This use case defines the contract for operations that involve loading and parsing environment
 * data from a JSON file into a list of {@link Environment} objects.
 * </p>
 */
public interface ReadEnvironmentJsonFileUseCase {

    /**
     * Reads a JSON file containing environment configuration data and parses it into a list of Environment objects.
     *
     * @param environmentFilePath the file path to the environment JSON file.
     * @return a list of Environment objects parsed from the JSON file.
     */
    List<Environment> readJsonFile(String environmentFilePath);
}
