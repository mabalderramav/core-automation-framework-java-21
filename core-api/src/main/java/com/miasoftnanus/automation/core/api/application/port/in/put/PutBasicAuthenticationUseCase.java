package com.miasoftnanus.automation.core.api.application.port.in.put;

import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;

/**
 * Use case for sending PUT requests with basic authentication.
 */
public interface PutBasicAuthenticationUseCase {
    /**
     * Sends a PUT request with basic authentication.
     *
     * @param apiRequest          request object.
     * @param endpoint            webservice endpoint.
     * @param basicAuthentication basic authentication.
     * @return response data.
     */
    ApiResponse putBasicAuthentication(final ApiRequest apiRequest,
                                       final String endpoint,
                                       final BasicAuthentication basicAuthentication);
}
