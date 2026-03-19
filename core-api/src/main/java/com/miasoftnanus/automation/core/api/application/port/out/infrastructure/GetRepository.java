package com.miasoftnanus.automation.core.api.application.port.out.infrastructure;

import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;

/**
 * Repository interface for sending GET requests.
 * This interface defines methods for sending GET requests to a web service endpoint,
 * with or without basic authentication.
 */
public interface GetRepository {
    /**
     * Sends a GET request.
     *
     * @param apiRequest request object.
     * @param endpoint   webservice endpoint.
     * @return response data.
     */
    ApiResponse get(final ApiRequest apiRequest, final String endpoint);

    /**
     * Sends a GET request with basic authentication.
     *
     * @param apiRequest          request object.
     * @param endpoint            webservice endpoint.
     * @param basicAuthentication basic authentication credentials.
     * @return response data.
     */
    ApiResponse getBasicAuthentication(final ApiRequest apiRequest,
                                       final String endpoint,
                                       final BasicAuthentication basicAuthentication);
}
