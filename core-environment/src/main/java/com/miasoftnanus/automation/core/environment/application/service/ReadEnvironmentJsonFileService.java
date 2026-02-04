package com.miasoftnanus.automation.core.environment.application.service;

import com.miasoftnanus.automation.core.environment.application.port.in.ReadEnvironmentJsonFileUseCase;
import com.miasoftnanus.automation.core.environment.application.port.out.persistence.ReadEnvironmentJsonFileRepository;
import com.miasoftnanus.automation.core.environment.model.Environment;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Service implementation for reading an environment JSON file and parsing it into a list of {@link Environment} objects.
 * <p>
 * This service relies on a repository interface, {@link ReadEnvironmentJsonFileRepository}, to perform the actual
 * reading and parsing of the JSON file.
 * </p>
 * <p>
 * This class implements the {@link ReadEnvironmentJsonFileUseCase} interface, which defines the use case
 * for accessing environment data stored in JSON files, delegating the interaction with the data layer to the repository.
 * </p>
 */
@RequiredArgsConstructor
public class ReadEnvironmentJsonFileService implements ReadEnvironmentJsonFileUseCase {
    private final ReadEnvironmentJsonFileRepository readEnvironmentJsonFileRepository;


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Environment> readJsonFile(String environmentFilePath) {
        return readEnvironmentJsonFileRepository.readJsonFile(environmentFilePath);
    }
}
