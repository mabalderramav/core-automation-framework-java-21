package com.miasoftnanus.automation.core.api.adapter.in.rest.get;

import com.miasoftnanus.automation.core.api.application.port.in.get.GetBasicAuthenticationUseCase;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;
import lombok.RequiredArgsConstructor;

/**
 * Controller for handling GET requests with basic authentication.
 * This class uses the GetBasicAuthenticationUseCase to process incoming API requests
 * and return responses with basic authentication credentials.
 */
@RequiredArgsConstructor
public class GetBasicAuthenticationController {
    private final GetBasicAuthenticationUseCase getBasicAuthenticationUseCase;

    /**
     * Handles a GET request with basic authentication.
     *
     * @param apiRequest          the API request containing headers, parameters, and body.
     * @param endpoint            the web service endpoint to which the request is sent.
     * @param basicAuthentication the basic authentication credentials.
     * @return the API response containing status code and response body.
     */
    public ApiResponse getBasicAuthentication(final ApiRequest apiRequest,
                                              final String endpoint,
                                              final BasicAuthentication basicAuthentication) {
        return getBasicAuthenticationUseCase.getBasicAuthentication(apiRequest, endpoint, basicAuthentication);
    }
}
