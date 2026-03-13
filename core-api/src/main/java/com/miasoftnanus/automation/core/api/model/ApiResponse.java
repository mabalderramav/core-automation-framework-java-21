package com.miasoftnanus.automation.core.api.model;

import lombok.experimental.Accessors;

import java.util.Objects;

/**
 * Defines Api response wrapper class.
 */
@Accessors(fluent = true)
public record ApiResponse(int statusCode, String body) {
    public ApiResponse {
        Objects.requireNonNull(body, "'body' must not be null");
        if (statusCode < 100 || statusCode > 599) {
            throw new IllegalArgumentException("'statusCode' must be between 100 and 599");
        }
    }
}
