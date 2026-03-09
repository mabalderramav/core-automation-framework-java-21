package com.miasoftnanus.automation.core.configuration.properties.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the {@link ApiConfigWords} enum.
 * This class tests the behavior of the {@code val()} method, which retrieves the string
 * representation of the reserved word associated with each enum constant.
 */
class ApiConfigWordsTest {

    @Test
    void testApiNameVal() {
        // Arrange
        ApiConfigWords apiConfigWord = ApiConfigWords.API_NAME;

        // Act
        String result = apiConfigWord.val();

        // Assert
        assertEquals("api.name", result, "The val() method should return the correct string representation of API_NAME.");
    }

    @Test
    void testApiVersionNameVal() {
        // Arrange
        ApiConfigWords apiConfigWord = ApiConfigWords.API_VERSION_NAME;

        // Act
        String result = apiConfigWord.val();

        // Assert
        assertEquals("api.versionName", result, "The val() method should return the correct string representation of API_VERSION_NAME.");
    }

    @Test
    void testApiAuthenticationTypeVal() {
        // Arrange
        ApiConfigWords apiConfigWord = ApiConfigWords.API_AUTHENTICATION_TYPE;

        // Act
        String result = apiConfigWord.val();

        // Assert
        assertEquals("api.authenticationType", result, "The val() method should return the correct string representation of API_AUTHENTICATION_TYPE.");
    }

    @Test
    void testApiAuthenticationUserTypeVal() {
        // Arrange
        ApiConfigWords apiConfigWord = ApiConfigWords.API_AUTHENTICATION_USER_TYPE;

        // Act
        String result = apiConfigWord.val();

        // Assert
        assertEquals("api.authenticationUserType", result, "The val() method should return the correct string representation of API_AUTHENTICATION_USER_TYPE.");
    }
}