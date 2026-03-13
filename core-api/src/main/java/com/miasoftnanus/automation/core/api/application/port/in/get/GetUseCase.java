package com.miasoftnanus.automation.core.api.application.port.in.get;

import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;

/**
 * Use case for sending GET requests.
 */
public interface GetUseCase {
    /**
     * Sends a GET request.
     *
     * @param apiRequest request object.
     * @param endpoint   webservice endpoint.
     * @return response data.
     */
    ApiResponse get(final ApiRequest apiRequest, final String endpoint);
}
