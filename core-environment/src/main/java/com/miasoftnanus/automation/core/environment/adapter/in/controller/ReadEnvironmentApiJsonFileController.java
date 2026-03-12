package com.miasoftnanus.automation.core.environment.adapter.in.controller;

import com.miasoftnanus.automation.core.environment.application.port.in.ReadEnvironmentApiJsonFileUseCase;
import com.miasoftnanus.automation.core.environment.model.EnvironmentApi;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Controller class responsible for handling operations related to reading environment API JSON files.
 * <p>
 * This class interacts with the {@code ReadEnvironmentApiJsonFileUseCase} to facilitate
 * the processing of JSON files containing environment API configuration data. It serves as an
 * entry point for converting the contents of such files into structured {@code EnvironmentApi} objects.
 * </p>
 */
@RequiredArgsConstructor
public class ReadEnvironmentApiJsonFileController {
    private final ReadEnvironmentApiJsonFileUseCase readEnvironmentApiJsonFileUseCase;

    /**
     * Reads a JSON file containing environment API configuration data and parses it into a list of {@code EnvironmentApi} objects.
     *
     * @param environmentFilePath the file path to the JSON file containing environment API configuration data.
     * @return a list of {@code EnvironmentApi} objects parsed from the JSON file.
     */
    public List<EnvironmentApi> readJsonFile(String environmentFilePath) {
        return readEnvironmentApiJsonFileUseCase.readJsonFile(environmentFilePath);
    }
}
