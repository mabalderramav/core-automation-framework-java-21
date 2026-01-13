package com.miasoftnanus.automation.core.environment.adapter.in.rest;

import com.miasoftnanus.automation.core.environment.application.port.in.ReadEnvironmentJsonFileUseCase;
import com.miasoftnanus.automation.core.environment.model.Environment;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Controller class responsible for handling operations related to reading environment JSON files.
 */
@RequiredArgsConstructor
public class ReadEnvironmentJsonFileController {
    private final ReadEnvironmentJsonFileUseCase readEnvironmentJsonFileUseCase;

    /**
     * Reads an environment JSON file and parses its contents into a list of {@link Environment} objects.
     *
     * @param environmentFilePath the file path of the environment JSON file to be read.
     * @return a list of {@link Environment} objects parsed from the JSON file.
     */
    public List<Environment> readJsonFile(String environmentFilePath) {
        return readEnvironmentJsonFileUseCase.readJsonFile(environmentFilePath);
    }
}
