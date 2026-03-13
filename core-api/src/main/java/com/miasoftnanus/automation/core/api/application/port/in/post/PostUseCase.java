package com.miasoftnanus.automation.core.api.application.port.in.post;

import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;

/**
 * Interface for sending POST requests to a web service.
 * This interface defines the contract for sending POST requests with an API request object
 * and receiving a response from the server.
 */
public interface PostUseCase {
    /**
     * Sends a POST request to the specified endpoint with the given API request.
     *
     * @param apiRequest request object containing the data to be sent.
     * @param endpoint   the web service endpoint to which the request is sent.
     * @return response data from the server.
     */
    ApiResponse post(final ApiRequest apiRequest, final String endpoint);
}
