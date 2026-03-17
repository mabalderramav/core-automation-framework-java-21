package com.miasoftnanus.automation.core.api.application.service.delete;

import com.miasoftnanus.automation.core.api.application.port.in.delete.DeleteUseCase;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.DeleteRepository;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import lombok.RequiredArgsConstructor;

/**
 * Service for deleting resources.
 */
@RequiredArgsConstructor
public class DeleteService implements DeleteUseCase {
    private final DeleteRepository deleteRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse delete(final ApiRequest apiRequest, final String endpoint) {
        return deleteRepository.delete(apiRequest, endpoint);
    }
}
