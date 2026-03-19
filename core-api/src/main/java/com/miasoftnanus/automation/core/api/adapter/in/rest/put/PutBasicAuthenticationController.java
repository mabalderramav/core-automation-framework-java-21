package com.miasoftnanus.automation.core.api.adapter.in.rest.put;

import com.miasoftnanus.automation.core.api.application.port.in.put.PutBasicAuthenticationUseCase;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;
import lombok.RequiredArgsConstructor;

/**
 * Controller for handling PUT requests with basic authentication.
 * This class uses a use case to process the request and return an API response.
 */
@RequiredArgsConstructor
public class PutBasicAuthenticationController {
    private final PutBasicAuthenticationUseCase putBasicAuthenticationUseCase;

    /**
     * Handles a PUT request with basic authentication.
     *
     * @param apiRequest          the API request containing headers, parameters, and body.
     * @param endpoint            the endpoint to which the request is sent.
     * @param basicAuthentication the basic authentication credentials.
     * @return ApiResponse containing the status code and response body.
     */
    public ApiResponse putBasicAuthentication(final ApiRequest apiRequest,
                                              final String endpoint,
                                              final BasicAuthentication basicAuthentication) {
        return putBasicAuthenticationUseCase.putBasicAuthentication(apiRequest, endpoint, basicAuthentication);
    }
}
