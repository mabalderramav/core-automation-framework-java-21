package com.miasoftnanus.automation.core.api.application.port.in.put;

import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;

/**
 * Use case for sending PUT requests.
 */
public interface PutUseCase {
    /**
     * Sends PUT request.
     *
     * @param apiRequest request object.
     * @param endpoint   webservice endpoint.
     * @return response data.
     */
    ApiResponse put(final ApiRequest apiRequest, final String endpoint);
}
