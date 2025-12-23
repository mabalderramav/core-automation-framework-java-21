package com.miasoftnanus.automation.core.utils.properties;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


class PropertiesFileReaderTest {

    @Test
    @DisplayName( "Should return property value")
    void getPropertyValue() {
        PropertiesFileReader reader = new PropertiesFileReader("./src/test/resources/properties/properties_test.properties");
        String value = reader.getPropertyValue("test.property");
        assertNotNull(value);
        assertEquals("test-value", value);
    }

    @Test
    @DisplayName( "Should return null if property doesn't exist")
    void getPropertyValue_nonexistentProperty_returnsNull() {
        PropertiesFileReader reader = new PropertiesFileReader("./src/test/resources/properties/properties_test.properties");
        String value = reader.getPropertyValue("nonexistent.property");
        assertNull(value);
    }
}