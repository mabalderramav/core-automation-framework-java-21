package com.miasoftnanus.automation.core.api.application.port.out.infrastructure;

import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;

/**
 * Repository interface for sending DELETE requests.
 */
public interface DeleteRepository {
    /**
     * Sends DELETE request.
     *
     * @param apiRequest request object.
     * @param endpoint   webservice endpoint.
     * @return response data.
     */
    ApiResponse delete(final ApiRequest apiRequest, final String endpoint);

    /**
     * Sends DELETE request with basic authentication.
     *
     * @param apiRequest          request object.
     * @param endpoint            webservice endpoint.
     * @param basicAuthentication basic authentication credentials.
     * @return response data.
     */
    ApiResponse deleteBasicAuthentication(final ApiRequest apiRequest,
                                          final String endpoint,
                                          final BasicAuthentication basicAuthentication);
}
