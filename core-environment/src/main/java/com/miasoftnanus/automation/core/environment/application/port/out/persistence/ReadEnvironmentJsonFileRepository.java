package com.miasoftnanus.automation.core.environment.application.port.out.persistence;

import com.miasoftnanus.automation.core.environment.model.Environment;

import java.util.List;

/**
 * Repository interface for reading and parsing environment configuration
 * from a JSON file into an {@link Environment} object.
 */
public interface ReadEnvironmentJsonFileRepository {

    /**
     * Reads the specified environment JSON file and parses it into a list of {@link Environment} objects.
     *
     * @param environmentFilePath the path to the environment JSON file to be read.
     * @return a list of parsed {@link Environment} objects.
     */
    List<Environment> readEnvironmentJsonFile(String environmentFilePath);
}
