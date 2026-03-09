package com.miasoftnanus.automation.core.configuration.properties.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommonConfigWordsTest {

    @Test
    void testEnvironmentNameVal() {
        // Arrange
        CommonConfigWords configWord = CommonConfigWords.ENVIRONMENT_NAME;

        // Act
        String result = configWord.val();

        // Assert
        assertEquals("environment.name", result, "The val() method should return the correct string representation of ENVIRONMENT_NAME.");
    }

    @Test
    void testEnvironmentFilePathVal() {
        // Arrange
        CommonConfigWords configWord = CommonConfigWords.ENVIRONMENT_FILE_PATH;

        // Act
        String result = configWord.val();

        // Assert
        assertEquals("environment.filePath", result, "The val() method should return the correct string representation of ENVIRONMENT_FILE_PATH.");
    }
}