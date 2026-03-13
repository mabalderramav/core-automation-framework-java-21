package com.miasoftnanus.automation.core.api.aplication.port.in.get;

import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;

/**
 * Use case for sending GET requests with basic authentication.
 */
public interface GetBasicAuthenticationUseCase {
    /**
     * Sends GET request with basic authentication.
     *
     * @param apiRequest          request object.
     * @param endpoint            webservice endpoint.
     * @param basicAuthentication basic authentication credentials.
     * @return response data.
     */
    ApiResponse getBasicAuthentication(final ApiRequest apiRequest,
                                       final String endpoint,
                                       final BasicAuthentication basicAuthentication);
}
