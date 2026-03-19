package com.miasoftnanus.automation.core.api.adapter.in.rest.delete;

import com.miasoftnanus.automation.core.api.application.port.in.delete.DeleteUseCase;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import lombok.RequiredArgsConstructor;

/**
 * Controller for handling DELETE requests.
 * This class uses a use case to process the request and return an API response.
 */
@RequiredArgsConstructor
public class DeleteController {
    private final DeleteUseCase deleteUseCase;

    /**
     * Handles a DELETE request.
     *
     * @param apiRequest the API request containing headers, parameters, and body
     * @param endpoint   the endpoint to which the request is sent
     * @return ApiResponse containing the status code and response body
     */
    public ApiResponse delete(final ApiRequest apiRequest, final String endpoint) {
        return deleteUseCase.delete(apiRequest, endpoint);
    }
}
