package com.miasoftnanus.automation.core.api.model;

import lombok.experimental.Accessors;

import java.util.Objects;

/**
 * Represents an HTTP API response containing a status code and a response body.
 * <p>
 * This record encapsulates the two key parts of an HTTP response:
 * - The status code, which indicates the outcome of the HTTP request (e.g., 200 for success, 404 for not found).
 * - The response body, which contains the content returned from the server.
 * </p>
 * <p>
 * Validation rules:
 * - The `statusCode` must be within the valid HTTP status code range of 100 to 599.
 * - The `body` must not be null.
 * </p>
 * <p>
 * Instances of this record are immutable and thread-safe.
 * </p>
 */
@Accessors(fluent = true)
public record ApiResponse(int statusCode, String body) {
    /**
     * Constructs an instance of {@code ApiResponse}.
     *
     * @param statusCode the HTTP status code of the response. Must be within the range 100 to 599 inclusive.
     * @param body       the response body content. Must not be null.
     * @throws NullPointerException     if {@code body} is null.
     * @throws IllegalArgumentException if {@code statusCode} is not within the range 100 to 599 inclusive.
     */
    public ApiResponse {
        Objects.requireNonNull(body, "'body' must not be null");
        if (statusCode < 100 || statusCode > 599) {
            throw new IllegalArgumentException("'statusCode' must be between 100 and 599");
        }
    }
}
