package com.miasoftnanus.automation.core.api.application.port.out.infrastructure;

import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;

/**
 * Repository interface for sending PUT requests.
 */
public interface PutRepository {
    /**
     * Sends PUT request.
     *
     * @param apiRequest request object.
     * @param endpoint   webservice endpoint.
     * @return response data.
     */
    ApiResponse put(final ApiRequest apiRequest, final String endpoint);

    /**
     * Sends a PUT request with basic authentication.
     *
     * @param apiRequest          request object.
     * @param endpoint            webservice endpoint.
     * @param basicAuthentication basic authentication.
     * @return response data.
     */
    ApiResponse putBasicAuthentication(final ApiRequest apiRequest,
                                       final String endpoint,
                                       final BasicAuthentication basicAuthentication);

    /**
     * Sends PUT request with form data and basic authentication.
     *
     * @param apiRequest          request object.
     * @param endpoint            webservice endpoint.
     * @param basicAuthentication basic authentication.
     * @return response data.
     */
    ApiResponse putFormDataBasicAuthentication(final ApiRequest apiRequest,
                                               final String endpoint,
                                               final BasicAuthentication basicAuthentication);
}
