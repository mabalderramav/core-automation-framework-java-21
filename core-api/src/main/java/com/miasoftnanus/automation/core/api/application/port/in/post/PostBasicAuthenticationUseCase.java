package com.miasoftnanus.automation.core.api.application.port.in.post;

import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;

/**
 * Interface for sending POST requests with basic authentication.
 * This interface defines the method to send a POST request while ensuring that the request is authenticated
 * using basic authentication.
 */
public interface PostBasicAuthenticationUseCase {
    /**
     * Sends POST request with basic authentication.
     *
     * @param apiRequest          request object.
     * @param endpoint            webservice endpoint.
     * @param basicAuthentication basic authentication.
     * @return response data.
     */
    ApiResponse postBasicAuthentication(final ApiRequest apiRequest,
                                        final String endpoint,
                                        final BasicAuthentication basicAuthentication);
}
