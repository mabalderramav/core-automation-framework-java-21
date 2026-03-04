package com.miasoftnanus.automation.core.environment.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VersionTest {

    @Test
    void constructor_ShouldInitializeFieldsToEmptyStrings() {
        // Act
        Version version = new Version();

        // Assert
        Assertions.assertEquals("", version.name());
        Assertions.assertEquals("", version.pathVersion());
    }

    @Test
    void settersAndGetters_ShouldUpdateAndRetrieveValues() {
        // Arrange
        Version version = new Version();
        String expectedName = "1.0.0";
        String expectedPathVersion = "v1";

        // Act
        version.name(expectedName);
        version.pathVersion(expectedPathVersion);

        // Assert
        Assertions.assertEquals(expectedName, version.name());
        Assertions.assertEquals(expectedPathVersion, version.pathVersion());
    }
}
