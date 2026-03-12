package com.miasoftnanus.automation.core.environment.application.port.out.infrastructure;

import com.miasoftnanus.automation.core.environment.model.EnvironmentUi;

import java.util.List;

/**
 * Repository interface for reading and parsing environment user interface (UI) configurations
 * from a JSON file into a list of {@link EnvironmentUi} objects.
 * <p>
 * This interface defines a contract for accessing and interpreting JSON files that
 * describe the user interface aspects of various environments, including the names of
 * the environments and their associated portals.
 * </p>
 */
public interface ReadEnvironmentUiJsonFileRepository {

    /**
     * Reads the specified environment UI JSON file and parses it into a list of {@link EnvironmentUi} objects.
     *
     * @param environmentFilePath the path to the environment UI JSON file to be read.
     * @return a list of parsed {@link EnvironmentUi} objects representing the environments and their associated portals.
     */
    List<EnvironmentUi> readJsonFile(String environmentFilePath);
}
