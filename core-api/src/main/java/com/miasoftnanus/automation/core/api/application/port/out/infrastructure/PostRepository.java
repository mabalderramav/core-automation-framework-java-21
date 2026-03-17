package com.miasoftnanus.automation.core.api.application.port.out.infrastructure;

import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;

/**
 * Interface for sending POST requests to a web service.
 * This interface defines the contract for sending POST requests with an API request object
 * and receiving a response from the server.
 */
public interface PostRepository {
    /**
     * Sends a POST request to the specified endpoint with the given API request.
     *
     * @param apiRequest request an object containing the data to be sent.
     * @param endpoint   the web service endpoint to which the request is sent.
     * @return response data from the server.
     */
    ApiResponse post(final ApiRequest apiRequest, final String endpoint);

    /**
     * Sends POST request with basic authentication.
     *
     * @param apiRequest          request object.
     * @param endpoint            webservice endpoint.
     * @param basicAuthentication basic authentication.
     * @return response data.
     */
    ApiResponse postBasicAuthentication(final ApiRequest apiRequest,
                                        final String endpoint,
                                        final BasicAuthentication basicAuthentication);

    /**
     * Sends POST request with form parameters and basic authentication.
     *
     * @param apiRequest          request object.
     * @param endpoint            webservice endpoint.
     * @param basicAuthentication basic authentication.
     * @return response data.
     */
    ApiResponse postFormParamsBasicAuthentication(final ApiRequest apiRequest,
                                                  final String endpoint,
                                                  final BasicAuthentication basicAuthentication);

    /**
     * Sends POST request with form data and basic authentication.
     *
     * @param apiRequest          request object.
     * @param endpoint            webservice endpoint.
     * @param basicAuthentication basic authentication.
     * @return response data.
     */
    ApiResponse postFormDataBasicAuthentication(final ApiRequest apiRequest,
                                                final String endpoint,
                                                final BasicAuthentication basicAuthentication);
}
