package com.miasoftnanus.automation.core.api.application.service.get;

import com.miasoftnanus.automation.core.api.application.port.in.get.GetBasicAuthenticationUseCase;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.GetRepository;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;
import lombok.RequiredArgsConstructor;

/**
 * Service implementation for handling GET requests with basic authentication.
 */
@RequiredArgsConstructor
public class GetBasicAuthenticationService implements GetBasicAuthenticationUseCase {
    private final GetRepository getRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse getBasicAuthentication(final ApiRequest apiRequest,
                                              final String endpoint,
                                              final BasicAuthentication basicAuthentication) {
        return getRepository.getBasicAuthentication(apiRequest, endpoint, basicAuthentication);
    }
}
