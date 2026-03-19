package com.miasoftnanus.automation.core.api.adapter.in.rest.post;

import com.miasoftnanus.automation.core.api.application.port.in.post.PostFormDataBasicAuthenticationUseCase;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;
import lombok.RequiredArgsConstructor;

/**
 * Controller for handling POST requests with form data and basic authentication.
 * This class uses a use case to process the request and return an API response.
 */
@RequiredArgsConstructor
public class PostFormDataBasicAuthenticationController {
    private final PostFormDataBasicAuthenticationUseCase postFormDataBasicAuthenticationUseCase;

    /**
     * Handles a POST request with form data and basic authentication.
     *
     * @param apiRequest          the API request containing headers, parameters, and body.
     * @param endpoint            the endpoint to which the request is sent.
     * @param basicAuthentication the basic authentication credentials.
     * @return ApiResponse containing the status code and response body.
     */
    public ApiResponse postFormDataBasicAuthentication(final ApiRequest apiRequest,
                                                       final String endpoint,
                                                       final BasicAuthentication basicAuthentication) {
        return postFormDataBasicAuthenticationUseCase
                .postFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication);
    }
}
