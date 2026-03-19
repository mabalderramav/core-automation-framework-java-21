package com.miasoftnanus.automation.core.api.adapter.in.rest.post;

import com.miasoftnanus.automation.core.api.application.port.in.post.PostUseCase;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import lombok.RequiredArgsConstructor;

/**
 * Controller for handling POST requests.
 * This class uses a use case to process the request and return an API response.
 */
@RequiredArgsConstructor
public class PostController {
    private final PostUseCase postUseCase;

    /**
     * Handles a POST request.
     *
     * @param apiRequest the API request containing headers, parameters, and body
     * @param endpoint   the endpoint to which the request is sent
     * @return ApiResponse containing the status code and response body
     */
    public ApiResponse post(final ApiRequest apiRequest, final String endpoint) {
        return postUseCase.post(apiRequest, endpoint);
    }
}
