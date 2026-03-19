package com.miasoftnanus.automation.core.api.bootstrap.client;

import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;

/**
 * Manages HTTP requests that require basic authentication.
 *
 * <p>
 * This interface provides methods for performing GET, POST, PUT, and DELETE
 * requests with basic authentication to specified endpoints. It supports
 * sending requests with different types of payloads, such as form data and
 * form parameters.
 * </p>
 */
public interface RequestBasicAuthenticationManager {
    /**
     * Performs a GET request with basic authentication to the specified endpoint.
     *
     * @param apiRequest          the API request containing headers, query parameters, and optional body content.
     * @param endpoint            the endpoint to which the request is sent.
     * @param basicAuthentication the basic authentication credentials used for the request.
     * @return ApiResponse containing the status code and response body received from the API.
     */
    ApiResponse get(final ApiRequest apiRequest,
                    final String endpoint,
                    final BasicAuthentication basicAuthentication);

    /**
     * Performs a POST request with basic authentication to the specified endpoint.
     *
     * @param apiRequest          the API request containing headers, parameters, and body.
     * @param endpoint            the endpoint to which the request is sent.
     * @param basicAuthentication the basic authentication credentials.
     * @return ApiResponse containing the status code and response body.
     */
    ApiResponse post(final ApiRequest apiRequest,
                     final String endpoint,
                     final BasicAuthentication basicAuthentication);

    /**
     * Performs a POST request with form data and basic authentication to the specified endpoint.
     *
     * @param apiRequest          the API request containing headers, parameters, and body.
     * @param endpoint            the endpoint to which the request is sent.
     * @param basicAuthentication the basic authentication credentials.
     * @return ApiResponse containing the status code and response body.
     */
    ApiResponse postFormData(final ApiRequest apiRequest,
                             final String endpoint,
                             final BasicAuthentication basicAuthentication);

    /**
     * Performs a POST request with form parameters and basic authentication to the specified endpoint.
     *
     * @param apiRequest          the API request containing headers, parameters, and body.
     * @param endpoint            the endpoint to which the request is sent.
     * @param basicAuthentication the basic authentication credentials.
     * @return ApiResponse containing the status code and response body.
     */
    ApiResponse postFormParams(final ApiRequest apiRequest,
                               final String endpoint,
                               final BasicAuthentication basicAuthentication);

    /**
     * Performs a PUT request with basic authentication to the specified endpoint.
     *
     * @param apiRequest          the API request containing headers, parameters, and body.
     * @param endpoint            the endpoint to which the request is sent.
     * @param basicAuthentication the basic authentication credentials.
     * @return ApiResponse containing the status code and response body.
     */
    ApiResponse put(final ApiRequest apiRequest,
                    final String endpoint,
                    final BasicAuthentication basicAuthentication);

    /**
     * Performs a PUT request with form data and basic authentication to the specified endpoint.
     *
     * @param apiRequest          the API request containing headers, parameters, and body.
     * @param endpoint            the endpoint to which the request is sent.
     * @param basicAuthentication the basic authentication credentials.
     * @return ApiResponse containing the status code and response body.
     */
    ApiResponse putFormData(final ApiRequest apiRequest,
                            final String endpoint,
                            final BasicAuthentication basicAuthentication);

    /**
     * Performs a DELETE request with basic authentication to the specified endpoint.
     *
     * @param apiRequest          the API request containing headers, parameters, and body.
     * @param endpoint            the endpoint to which the request is sent.
     * @param basicAuthentication the basic authentication credentials.
     * @return ApiResponse containing the status code and response body.
     */
    ApiResponse delete(final ApiRequest apiRequest,
                       final String endpoint,
                       final BasicAuthentication basicAuthentication);
}
