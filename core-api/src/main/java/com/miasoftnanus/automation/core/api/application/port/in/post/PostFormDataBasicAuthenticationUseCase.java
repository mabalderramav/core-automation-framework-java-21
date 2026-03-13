package com.miasoftnanus.automation.core.api.application.port.in.post;

import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;

/**
 * Interface for sending POST requests with form data and basic authentication.
 * This interface extends the basic functionality of sending POST requests with form data
 * while ensuring that the request is authenticated using basic authentication.
 */
public interface PostFormDataBasicAuthenticationUseCase {
    /**
     * Sends POST request with form data and basic authentication.
     *
     * @param apiRequest          request object.
     * @param endpoint            webservice endpoint.
     * @param basicAuthentication basic authentication.
     * @return response data.
     */
    ApiResponse postFormDataBasicAuthentication(final ApiRequest apiRequest,
                                                final String endpoint,
                                                final BasicAuthentication basicAuthentication);
}
