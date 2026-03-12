package com.miasoftnanus.automation.core.environment.application.port.out.infrastructure;

import com.miasoftnanus.automation.core.environment.model.EnvironmentApi;

import java.util.List;

/**
 * Repository interface for reading and parsing environment API configurations
 * from a JSON file into a list of {@link EnvironmentApi} objects.
 * <p>
 * This interface defines the contract for reading a JSON file that specifies the API
 * configurations for a given environment. It allows for structured extraction of data
 * such as the environment name and its associated APIs.
 * </p>
 */
public interface ReadEnvironmentApiJsonFileRepository {

    /**
     * Reads the specified environment API JSON file and parses it into a list of {@link EnvironmentApi} objects.
     *
     * @param environmentFilePath the file path to the environment API JSON file to be read.
     * @return a list of {@link EnvironmentApi} objects parsed from the JSON file.
     */
    List<EnvironmentApi> readJsonFile(String environmentFilePath);
}
