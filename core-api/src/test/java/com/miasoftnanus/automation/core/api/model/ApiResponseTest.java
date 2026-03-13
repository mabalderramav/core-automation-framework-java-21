package com.miasoftnanus.automation.core.api.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiResponseTest {

    @Test
    void constructor_acceptsValidStatusCodeAndBody() {
        ApiResponse response = new ApiResponse(200, "ok");

        assertEquals(200, response.statusCode());
        assertEquals("ok", response.body());
    }

    @Test
    void constructor_rejectsNullBody() {
        NullPointerException ex = assertThrows(NullPointerException.class,
                () -> new ApiResponse(200, null));

        assertEquals("'body' must not be null", ex.getMessage());
    }

    @Test
    void constructor_rejectsStatusCodeBelow100() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new ApiResponse(99, "x"));

        assertEquals("'statusCode' must be between 100 and 599", ex.getMessage());
    }

    @Test
    void constructor_rejectsStatusCodeAbove599() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new ApiResponse(600, "x"));

        assertEquals("'statusCode' must be between 100 and 599", ex.getMessage());
    }

    @Test
    void constructor_acceptsLowerAndUpperBoundaries() {
        ApiResponse min = new ApiResponse(100, "min");
        ApiResponse max = new ApiResponse(599, "max");

        assertEquals(100, min.statusCode());
        assertEquals("min", min.body());

        assertEquals(599, max.statusCode());
        assertEquals("max", max.body());
    }

    @Test
    void recordEqualityAndHashCode_workForSameValues() {
        ApiResponse a = new ApiResponse(201, "created");
        ApiResponse b = new ApiResponse(201, "created");

        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    void toString_containsComponentNames() {
        ApiResponse response = new ApiResponse(204, "");
        String s = response.toString();

        assertTrue(s.contains("statusCode"), "toString should contain record component name 'statusCode'");
        assertTrue(s.contains("body"), "toString should contain record component name 'body'");
    }
}

