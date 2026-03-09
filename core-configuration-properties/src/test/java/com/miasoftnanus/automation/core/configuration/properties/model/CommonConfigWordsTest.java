package com.miasoftnanus.automation.core.configuration.properties.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the {@link CommonConfigWords} enum.
 * This class verifies the functionality of the {@code val()} method, which retrieves the
 * string representation of the enum's associated word.
 */
class CommonConfigWordsTest {

    @Test
    void testEnvironmentNameVal() {
        // Arrange
        CommonConfigWords configWord = CommonConfigWords.ENVIRONMENT_NAME;

        // Act
        String result = configWord.val();

        // Assert
        assertEquals("environmentName", result, "The val() method should return the correct string representation of ENVIRONMENT_NAME.");
    }
}