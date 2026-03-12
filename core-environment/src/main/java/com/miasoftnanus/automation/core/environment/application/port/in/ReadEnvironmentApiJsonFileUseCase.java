package com.miasoftnanus.automation.core.environment.application.port.in;

import com.miasoftnanus.automation.core.environment.model.EnvironmentApi;

import java.util.List;

/**
 * Use case for reading a JSON file containing environment API configurations.
 * <p>
 * This interface defines the contract for operations that involve loading and parsing
 * environment API data from a JSON file into a list of {@code EnvironmentApi} objects.
 * The parsed data typically includes an environment's name and its associated APIs,
 * providing a structured representation of the environment's API configuration.
 * </p>
 */
public interface ReadEnvironmentApiJsonFileUseCase {

    /**
     * Reads a JSON file containing environment API configuration data and parses it into a list of EnvironmentApi objects.
     *
     * @param environmentFilePath the file path to the JSON file containing environment API configuration data.
     * @return a list of EnvironmentApi objects parsed from the JSON file.
     */
    List<EnvironmentApi> readJsonFile(String environmentFilePath);
}
