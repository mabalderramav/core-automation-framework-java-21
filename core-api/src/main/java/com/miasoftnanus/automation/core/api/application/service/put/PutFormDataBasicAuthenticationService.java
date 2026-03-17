package com.miasoftnanus.automation.core.api.application.service.put;

import com.miasoftnanus.automation.core.api.application.port.in.put.PutFormDataBasicAuthenticationUseCase;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.PutRepository;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;
import lombok.RequiredArgsConstructor;

/**
 * Service implementation for sending PUT requests with form data and basic authentication.
 */
@RequiredArgsConstructor
public class PutFormDataBasicAuthenticationService implements PutFormDataBasicAuthenticationUseCase {
    private final PutRepository putRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse putFormDataBasicAuthentication(final ApiRequest apiRequest,
                                                      final String endpoint,
                                                      final BasicAuthentication basicAuthentication) {
        return putRepository.putFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication);
    }
}
