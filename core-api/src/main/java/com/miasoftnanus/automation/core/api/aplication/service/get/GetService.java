package com.miasoftnanus.automation.core.api.aplication.service.get;

import com.miasoftnanus.automation.core.api.aplication.port.in.get.GetUseCase;
import com.miasoftnanus.automation.core.api.aplication.port.out.persistence.GetRepository;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import lombok.RequiredArgsConstructor;

/**
 * Service implementation for handling GET requests.
 */
@RequiredArgsConstructor
public class GetService implements GetUseCase {
    private final GetRepository getRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse get(final ApiRequest apiRequest, final String endpoint) {
        return getRepository.get(apiRequest, endpoint);
    }
}
