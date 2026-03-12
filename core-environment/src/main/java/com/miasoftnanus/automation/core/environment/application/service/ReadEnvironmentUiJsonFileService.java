package com.miasoftnanus.automation.core.environment.application.service;

import com.miasoftnanus.automation.core.environment.application.port.in.ReadEnvironmentUiJsonFileUseCase;
import com.miasoftnanus.automation.core.environment.application.port.out.infrastructure.ReadEnvironmentUiJsonFileRepository;
import com.miasoftnanus.automation.core.environment.model.EnvironmentUi;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Service implementation for reading an environment UI JSON file and parsing it into a list of {@link EnvironmentUi} objects.
 * <p>
 * This service relies on a repository interface, {@link ReadEnvironmentUiJsonFileRepository}, to handle the actual
 * reading and parsing of the JSON file. It serves as a bridge between the use case definition and the repository
 * implementation, facilitating the reading and processing of environment UI data.
 * </p>
 * <p>
 * This class implements the {@link ReadEnvironmentUiJsonFileUseCase} interface, which defines the use case for accessing
 * environment UI data from JSON files. The service delegates the interaction with the data layer to the repository.
 * </p>
 */
@RequiredArgsConstructor
public class ReadEnvironmentUiJsonFileService implements ReadEnvironmentUiJsonFileUseCase {
    private final ReadEnvironmentUiJsonFileRepository readEnvironmentUiJsonFileRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<EnvironmentUi> readJsonFile(String environmentFilePath) {
        return readEnvironmentUiJsonFileRepository.readJsonFile(environmentFilePath);
    }
}
