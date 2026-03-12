package com.miasoftnanus.automation.core.environment.application.service;

import com.miasoftnanus.automation.core.environment.application.port.in.ReadEnvironmentApiJsonFileUseCase;
import com.miasoftnanus.automation.core.environment.application.port.out.infrastructure.ReadEnvironmentApiJsonFileRepository;
import com.miasoftnanus.automation.core.environment.model.EnvironmentApi;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Service implementation for reading an environment API JSON file and parsing it into a list of {@link EnvironmentApi} objects.
 * <p>
 * This service depends on the repository interface {@link ReadEnvironmentApiJsonFileRepository} to handle the actual
 * reading and parsing of JSON files. It acts as a bridge between the use case definition and the repository implementation,
 * facilitating the extraction and management of environment API configurations.
 * </p>
 * <p>
 * This class implements the {@link ReadEnvironmentApiJsonFileUseCase} interface, which defines the use case for accessing
 * environment API data from JSON files. The interaction with the data layer is delegated to the repository.
 * </p>
 */
@RequiredArgsConstructor
public class ReadEnvironmentApiJsonFileService implements ReadEnvironmentApiJsonFileUseCase {
    private final ReadEnvironmentApiJsonFileRepository readEnvironmentApiJsonFileRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<EnvironmentApi> readJsonFile(String environmentFilePath) {
        return readEnvironmentApiJsonFileRepository.readJsonFile(environmentFilePath);
    }
}
