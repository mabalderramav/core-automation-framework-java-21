package com.miasoftnanus.automation.core.api.adapter.in.rest.post;

import com.miasoftnanus.automation.core.api.application.port.in.post.PostBasicAuthenticationUseCase;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;
import lombok.RequiredArgsConstructor;

/**
 * Controller for handling POST requests with basic authentication.
 * This class is responsible for processing API requests that require basic authentication
 * and returning the appropriate response.
 */
@RequiredArgsConstructor
public class PostBasicAuthenticationController {
    private final PostBasicAuthenticationUseCase postBasicAuthenticationUseCase;

    /**
     * Handles a POST request with basic authentication.
     *
     * @param apiRequest          the API request containing headers, parameters, and body
     * @param endpoint            the endpoint to which the request is sent
     * @param basicAuthentication the basic authentication credentials
     * @return ApiResponse containing the status code and response body
     */
    public ApiResponse postBasicAuthentication(final ApiRequest apiRequest,
                                               final String endpoint,
                                               final BasicAuthentication basicAuthentication) {
        return postBasicAuthenticationUseCase.postBasicAuthentication(apiRequest, endpoint, basicAuthentication);
    }
}
