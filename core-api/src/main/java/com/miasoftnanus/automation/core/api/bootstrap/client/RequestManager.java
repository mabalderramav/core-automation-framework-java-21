package com.miasoftnanus.automation.core.api.bootstrap.client;

import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;

/**
 * Interface for managing HTTP API requests. Provides methods for performing various HTTP
 * operations such as GET, POST, PUT, and DELETE.
 * <p>
 * Each method expects an ApiRequest object, which encapsulates headers, parameters,
 * form data, and body information for the request, and an endpoint specifying the
 * target URL to send the request to. Methods return an ApiResponse object containing the
 * HTTP status code and the response body from the server.
 */
public interface RequestManager {
    /**
     * Performs a GET request to the specified endpoint.
     *
     * @param apiRequest the API request containing headers, query parameters, and other configurations.
     *                   The {@code headers} map within the {@code apiRequest} is used as the headers
     *                   for the GET request, and the {@code params} map is used as the query parameters.
     * @param endpoint   the endpoint to which the request is sent.
     * @return ApiResponse containing the HTTP status code and the response body returned from the server.
     * The status code indicates the outcome of the HTTP request, and the body contains
     * the content returned by the server.
     */
    ApiResponse get(final ApiRequest apiRequest, final String endpoint);

    /**
     * Performs a POST request to the specified endpoint with the provided API request details.
     *
     * @param apiRequest the API request containing headers, body, and other configurations.
     *                   The {@code body} field within the {@code apiRequest} is used as the payload for the POST request.
     *                   The {@code headers} map specifies the HTTP headers to include in the request.
     * @param endpoint   the endpoint to which the POST request is sent.
     *                   This parameter specifies the target URL of the resource being interacted with.
     * @return ApiResponse containing the HTTP status code and the response body returned from the server.
     * The status code indicates the result of the HTTP request, and the body contains the content
     * returned by the server.
     */
    ApiResponse post(final ApiRequest apiRequest, final String endpoint);

    /**
     * Performs a PUT request to the specified endpoint with the given API request details.
     *
     * @param apiRequest the API request containing headers, body, and additional configurations.
     *                   The {@code body} field within the {@code apiRequest} is used as the payload for the PUT request.
     *                   The {@code headers} map specifies the HTTP headers to include in the request.
     * @param endpoint   the endpoint to which the PUT request is sent.
     *                   This parameter specifies the target URL of the resource being updated or modified.
     * @return ApiResponse containing the HTTP status code and the response body returned from the server.
     * The status code indicates the result of the HTTP request, and the body contains the content
     * returned by the server.
     */
    ApiResponse put(final ApiRequest apiRequest, final String endpoint);


    /**
     * Performs a DELETE request to the specified endpoint with the provided API request details.
     *
     * @param apiRequest the API request containing headers, query parameters, and other configurations.
     *                   The {@code headers} map within the {@code apiRequest} is used as the headers
     *                   for the DELETE request, and the {@code params} map is used as the query parameters.
     * @param endpoint   the endpoint to which the DELETE request is sent.
     *                   This parameter specifies the target URL of the resource to be deleted.
     * @return ApiResponse containing the HTTP status code and the response body returned from the server.
     * The status code indicates the result of the HTTP request, and the body contains the content
     * returned by the server, if any.
     */
    ApiResponse delete(final ApiRequest apiRequest, final String endpoint);
}
