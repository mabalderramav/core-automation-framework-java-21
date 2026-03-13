package com.miasoftnanus.automation.core.api.application.port.in.put;

import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;

/**
 * Use case for sending PUT requests with form data and basic authentication.
 */
public interface PutFormDataBasicAuthenticationUseCase {
    /**
     * Sends PUT request with form data and basic authentication.
     *
     * @param apiRequest          request object.
     * @param endpoint            webservice endpoint.
     * @param basicAuthentication basic authentication.
     * @return response data.
     */
    ApiResponse putFormDataBasicAuthentication(final ApiRequest apiRequest,
                                               final String endpoint,
                                               final BasicAuthentication basicAuthentication);
}
