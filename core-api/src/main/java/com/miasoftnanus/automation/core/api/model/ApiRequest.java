package com.miasoftnanus.automation.core.api.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents an API request containing headers, query parameters,
 * form data, and an optional body payload.
 * <p>
 * This class allows the user to configure various aspects of an API
 * request such as headers, query parameters, and the request body.
 * It initializes maps for headers, query parameters, and form data
 * to ensure that these fields are always available and can be modified
 * independently of one another.
 * <p>
 * <p>
 * The body field is initialized as an empty string by default.
 * </p>
 * <p>
 * Key Features:
 * - Encapsulates HTTP headers, query parameters, and form data.
 * - Provides a fluent API for setting these fields via Lombok's
 * `@Accessors` annotation.
 * - Ensures initialized collections are independent and not shared across instances.
 * - Body defaults to an empty string to reduce nullability risks.
 * </p>
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
     * Constructs a new instance of the {@code ApiRequest} class.
     * <p>
     * Initializes the {@code headers}, {@code params}, and {@code formData} fields
     * as empty {@link HashMap} instances to ensure they are always ready for use.
     * The {@code body} field is initialized to an empty string.
     * <p>
     * This ensures that all collections are independent instances, preventing accidental
     * sharing between different components or threads.
     */
    public ApiRequest() {
        headers = new HashMap<>();
        params = new HashMap<>();
        formData = new HashMap<>();
        body = EMPTY_STRING;
    }
}
