package com.miasoftnanus.automation.core.api.adapter.in.rest.put;

import com.miasoftnanus.automation.core.api.application.port.in.put.PutUseCase;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import lombok.RequiredArgsConstructor;

/**
 * Controller for handling PUT requests.
 * This class uses a use case to process the request and return an API response.
 */
@RequiredArgsConstructor
public class PutController {
    private final PutUseCase putUseCase;

    /**
     * Handles a PUT request.
     *
     * @param apiRequest the API request containing headers, parameters, and body.
     * @param endpoint   the endpoint to which the request is sent.
     * @return ApiResponse containing the status code and response body.
     */
    public ApiResponse put(final ApiRequest apiRequest, final String endpoint) {
        return putUseCase.put(apiRequest, endpoint);
    }
}
