package com.miasoftnanus.automation.core.api.adapter.in.rest.put;

import com.miasoftnanus.automation.core.api.application.port.in.put.PutFormDataBasicAuthenticationUseCase;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;
import lombok.RequiredArgsConstructor;

/**
 * Controller for handling PUT requests with form data and basic authentication.
 * This class uses a use case to process the request and return an API response.
 */
@RequiredArgsConstructor
public class PutFormDataBasicAuthenticationController {
    private final PutFormDataBasicAuthenticationUseCase putFormDataBasicAuthenticationUseCase;

    /**
     * Handles a PUT request with form data and basic authentication.
     *
     * @param apiRequest          the API request containing headers, parameters, and body.
     * @param endpoint            the endpoint to which the request is sent.
     * @param basicAuthentication the basic authentication credentials.
     * @return ApiResponse containing the status code and response body.
     */
    public ApiResponse putFormDataBasicAuthentication(final ApiRequest apiRequest,
                                                      final String endpoint,
                                                      final BasicAuthentication basicAuthentication) {
        return putFormDataBasicAuthenticationUseCase
                .putFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication);
    }
}
