package com.miasoftnanus.automation.core.api.aplication.service.delete;

import com.miasoftnanus.automation.core.api.aplication.port.in.delete.DeleteBasicAuthenticationUseCase;
import com.miasoftnanus.automation.core.api.aplication.port.out.persistence.DeleteRepository;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;
import lombok.RequiredArgsConstructor;

/**
 * Service for deleting basic authentication.
 */
@RequiredArgsConstructor
public class DeleteBasicAuthenticationService implements DeleteBasicAuthenticationUseCase {
    private final DeleteRepository deleteRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse deleteBasicAuthentication(final ApiRequest apiRequest,
                                                 final String endpoint,
                                                 final BasicAuthentication basicAuthentication) {
        return deleteRepository.deleteBasicAuthentication(apiRequest, endpoint, basicAuthentication);
    }
}
