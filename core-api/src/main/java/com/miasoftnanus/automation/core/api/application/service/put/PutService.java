package com.miasoftnanus.automation.core.api.application.service.put;

import com.miasoftnanus.automation.core.api.application.port.in.put.PutUseCase;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.PutRepository;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import lombok.RequiredArgsConstructor;

/**
 * Service implementation for sending PUT requests.
 */
@RequiredArgsConstructor
public class PutService implements PutUseCase {
    private final PutRepository putRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse put(final ApiRequest apiRequest, final String endpoint) {
        return putRepository.put(apiRequest, endpoint);
    }
}
