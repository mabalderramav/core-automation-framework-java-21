package com.miasoftnanus.automation.core.environment.application.port.in;

import com.miasoftnanus.automation.core.environment.model.EnvironmentUi;

import java.util.List;

/**
 * Use case for reading a JSON file containing environment user interface configurations.
 *
 * <p>
 * This interface defines the contract for operations that involve loading and parsing
 * environment user interface data from a JSON file into a list of {@link EnvironmentUi} objects.
 * The parsed data typically includes an environment's name and its associated portals,
 * providing a structured representation of the environment's user interface.
 * </p>
 */
public interface ReadEnvironmentUiJsonFileUseCase {

    /**
     * Reads a JSON file containing environment UI configuration data and parses it into a list of {@link EnvironmentUi} objects.
     *
     * @param environmentFilePath the file path to the JSON file containing environment UI configuration data.
     * @return a list of {@link EnvironmentUi} objects parsed from the JSON file.
     */
    List<EnvironmentUi> readJsonFile(String environmentFilePath);
}
