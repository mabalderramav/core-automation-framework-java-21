package com.miasoftnanus.automation.core.configuration.properties.application.service;

import com.miasoftnanus.automation.core.configuration.properties.application.port.in.ReadPropertiesFileUiUseCase;
import com.miasoftnanus.automation.core.configuration.properties.application.port.out.infrastructure.ReadPropertiesFileUiRepository;
import com.miasoftnanus.automation.core.configuration.properties.model.UiConfig;
import lombok.RequiredArgsConstructor;

/**
 * A service class responsible for reading UI-specific properties from a file
 * and returning the configuration as an instance of {@link UiConfig}.
 * <p>
 * This class implements the {@link ReadPropertiesFileUiUseCase} interface
 * and delegates the actual file reading and parsing logic to the
 * {@link ReadPropertiesFileUiRepository} repository.
 * </p>
 * <p>
 * The primary purpose of this service is to provide an abstraction that
 * bridges the application layer and the infrastructure layer, ensuring
 * that UI-related configuration files can be read and converted into
 * usable {@link UiConfig} objects for the application.
 * </p>
 * <p>
 * This service is used to load environment-specific or user-defined
 * UI configuration settings dynamically during runtime.
 * </p>
 */
@RequiredArgsConstructor
public class ReadPropertiesFileUiService implements ReadPropertiesFileUiUseCase {
    private final ReadPropertiesFileUiRepository readPropertiesFileUiRepository;


    /**
     * {@inheritDoc}
     */
    @Override
    public UiConfig readPropertiesFile(String propertyFilePath) {
        return readPropertiesFileUiRepository.readPropertiesFile(propertyFilePath);
    }
}
