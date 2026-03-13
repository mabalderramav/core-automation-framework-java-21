package com.miasoftnanus.automation.core.api.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiRequestTest {

    @Test
    void constructor_initializesCollectionsAndBody() {
        ApiRequest request = new ApiRequest();

        assertNotNull(request.headers(), "headers map must be initialized");
        assertNotNull(request.params(), "params map must be initialized");
        assertNotNull(request.formData(), "formData map must be initialized");
        assertNotNull(request.body(), "body must be initialized");

        assertTrue(request.headers().isEmpty(), "headers must be empty by default");
        assertTrue(request.params().isEmpty(), "params must be empty by default");
        assertTrue(request.formData().isEmpty(), "formData must be empty by default");
        assertEquals("", request.body(), "body must be empty string by default");
    }

    @Test
    void mapsAreIndependentInstances() {
        ApiRequest request = new ApiRequest();

        request.headers().put("h", "v");
        request.params().put("p", "v");
        request.formData().put("f", "v");

        assertEquals(1, request.headers().size());
        assertEquals(1, request.params().size());
        assertEquals(1, request.formData().size());

        // ensure no accidental sharing
        assertNull(request.params().get("h"));
        assertNull(request.formData().get("h"));
        assertNull(request.headers().get("p"));
        assertNull(request.formData().get("p"));
        assertNull(request.headers().get("f"));
        assertNull(request.params().get("f"));

        assertNotSame(request.headers(), request.params());
        assertNotSame(request.headers(), request.formData());
        assertNotSame(request.params(), request.formData());
    }

    @Test
    void fluentSetters_workAndPreservePreviouslyInitializedMaps() {
        ApiRequest request = new ApiRequest();

        // capture references so we can assert they are not replaced
        var headersRef = request.headers();
        var paramsRef = request.params();
        var formDataRef = request.formData();

        request.body("{");
        assertEquals("{", request.body());

        // Lombok-generated fluent setters return ApiRequest
        assertSame(request, request.headers(headersRef));
        assertSame(request, request.params(paramsRef));
        assertSame(request, request.formData(formDataRef));

        assertSame(headersRef, request.headers());
        assertSame(paramsRef, request.params());
        assertSame(formDataRef, request.formData());
    }

    @Test
    void setters_allowReplacingMaps() {
        ApiRequest request = new ApiRequest();

        var newHeaders = new java.util.HashMap<String, String>();
        newHeaders.put("Authorization", "Bearer token");

        request.headers(newHeaders);

        assertSame(newHeaders, request.headers());
        assertEquals("Bearer token", request.headers().get("Authorization"));
    }
}

