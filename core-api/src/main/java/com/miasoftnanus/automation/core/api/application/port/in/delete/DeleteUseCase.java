package com.miasoftnanus.automation.core.api.application.port.in.delete;

import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;

/**
 * Defines methods to send DELETE requests.
 */
public interface DeleteUseCase {
    /**
     * Sends DELETE request.
     *
     * @param apiRequest request object.
     * @param endpoint   webservice endpoint.
     * @return response data.
     */
    ApiResponse delete(final ApiRequest apiRequest, final String endpoint);
}
