package com.miasoftnanus.automation.core.environment.adapter.in.controller;

import com.miasoftnanus.automation.core.environment.application.port.in.ReadEnvironmentUiJsonFileUseCase;
import com.miasoftnanus.automation.core.environment.model.EnvironmentUi;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Controller class responsible for handling operations related to reading environment UI JSON files.
 * <p>
 * This class interacts with the {@link ReadEnvironmentUiJsonFileUseCase} to facilitate
 * the parsing of JSON files containing environment user interface configuration data.
 * It serves as an entry point for processing environment UI configurations,
 * converting the contents of the JSON files into structured {@link EnvironmentUi} objects.
 * </p>
 */
@RequiredArgsConstructor
public class ReadEnvironmentUiJsonFileController {
    private final ReadEnvironmentUiJsonFileUseCase readEnvironmentUiJsonFileUseCase;

    /**
     * Reads a JSON file containing environment user interface configuration data
     * and parses its contents into a list of {@link EnvironmentUi} objects.
     *
     * @param environmentFilePath the file path to the JSON file containing
     *                            environment user interface configuration data.
     * @return a list of {@link EnvironmentUi} objects parsed from the JSON file.
     */
    public List<EnvironmentUi> readJsonFile(String environmentFilePath) {
        return readEnvironmentUiJsonFileUseCase.readJsonFile(environmentFilePath);
    }
}
