package com.miasoftnanus.automation.core.api.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

/**
 * Models request data.
 */
@Accessors(fluent = true)
@Data
public class ApiRequest {

    private static final String EMPTY_STRING = "";

    private Map<String, String> headers;
    private Map<String, String> params;
    private Map<String, String> formData;
    private String body;

    /**
     * Initializes an instance of {@link ApiRequest}.
     */
    public ApiRequest() {
        headers = new HashMap<>();
        params = new HashMap<>();
        formData = new HashMap<>();
        body = EMPTY_STRING;
    }
}
