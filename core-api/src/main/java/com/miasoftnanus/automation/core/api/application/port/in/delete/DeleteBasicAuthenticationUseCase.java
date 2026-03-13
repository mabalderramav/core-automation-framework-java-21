package com.miasoftnanus.automation.core.api.application.port.in.delete;

import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;

/**
 * Defines methods to send DELETE requests with basic authentication.
 */
public interface DeleteBasicAuthenticationUseCase {
    /**
     * Sends DELETE request with basic authentication.
     *
     * @param apiRequest          request object.
     * @param endpoint            webservice endpoint.
     * @param basicAuthentication basic authentication credentials.
     * @return response data.
     */
    ApiResponse deleteBasicAuthentication(final ApiRequest apiRequest,
                                          final String endpoint,
                                          final BasicAuthentication basicAuthentication);
}
