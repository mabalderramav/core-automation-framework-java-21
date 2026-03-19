package com.miasoftnanus.automation.core.api.adapter.in.rest.get;

import com.miasoftnanus.automation.core.api.application.port.in.get.GetUseCase;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import lombok.RequiredArgsConstructor;

/**
 * Controller for handling GET requests.
 * This class uses the GetUseCase to process incoming API requests and return responses.
 */
@RequiredArgsConstructor
public class GetController {
    private final GetUseCase getUseCase;

    /**
     * Handles a GET request.
     *
     * @param apiRequest the API request containing headers, parameters, and body.
     * @param endpoint   the web service endpoint to which the request is sent.
     * @return the API response containing status code and response body.
     */
    public ApiResponse get(final ApiRequest apiRequest, final String endpoint) {
        return getUseCase.get(apiRequest, endpoint);
    }
}
