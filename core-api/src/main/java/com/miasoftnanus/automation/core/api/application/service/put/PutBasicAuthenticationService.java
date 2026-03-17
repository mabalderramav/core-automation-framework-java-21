package com.miasoftnanus.automation.core.api.application.service.put;

import com.miasoftnanus.automation.core.api.application.port.in.put.PutBasicAuthenticationUseCase;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.PutRepository;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;
import lombok.RequiredArgsConstructor;

/**
 * Service implementation for sending PUT requests with basic authentication.
 */
@RequiredArgsConstructor
public class PutBasicAuthenticationService implements PutBasicAuthenticationUseCase {
    private final PutRepository putRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse putBasicAuthentication(final ApiRequest apiRequest,
                                              final String endpoint,
                                              final BasicAuthentication basicAuthentication) {
        return putRepository.putBasicAuthentication(apiRequest, endpoint, basicAuthentication);
    }
}
