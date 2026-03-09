package com.miasoftnanus.automation.core.configuration.properties.application.service;

import com.miasoftnanus.automation.core.configuration.properties.application.port.in.ReadPropertiesFileApiUseCase;
import com.miasoftnanus.automation.core.configuration.properties.application.port.out.infrastructure.ReadPropertiesFileApiRepository;
import com.miasoftnanus.automation.core.configuration.properties.model.ApiConfig;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReadPropertiesFileApiService implements ReadPropertiesFileApiUseCase {
    private final ReadPropertiesFileApiRepository readPropertiesFileApiRepository;

    @Override
    public ApiConfig readPropertiesFile(String propertyFilePath) {
        return readPropertiesFileApiRepository.readPropertiesFile(propertyFilePath);
    }
}
