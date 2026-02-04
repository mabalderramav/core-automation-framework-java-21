package com.miasoftnanus.automation.core.utils.json;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JsonFileReaderTest {

    @Test
    @DisplayName("Should load json object from file")
    void loadJsonObjectFromFile() {
        var json = JsonFileReader.loadJsonObjectFromFile("./src/test/resources/json/json_test.json");
        assertNotNull(json);
        assertEquals("Test", json.get("name").getAsString());
        assertEquals(123, json.get("value").getAsInt());
        assertTrue(json.get("active").getAsBoolean());
    }

    @Test
    @DisplayName("Should load json from file")
    void loadJsonFromFile() {
        var json = JsonFileReader.loadJsonFromFile("./src/test/resources/json/json_test.json");
        assertNotNull(json);
        assertInstanceOf(JsonObject.class, json);
        var obj = (com.google.gson.JsonObject) json;
        assertEquals("Test", obj.get("name").getAsString());
    }

    @Test
    @DisplayName("Should load json string from file")
    void loadJsonStringFromFile() {
        var jsonString = JsonFileReader.loadJsonStringFromFile("./src/test/resources/json/json_test.json");
        assertNotNull(jsonString);
        assertTrue(jsonString.contains("Test"));
        assertTrue(jsonString.contains("123"));
        assertTrue(jsonString.contains("active"));
    }

    @Test
    @DisplayName("Should return empty JsonObject for non-existent file")
    void loadJsonObjectFromFile_nonExistentFile() {
        var json = JsonFileReader.loadJsonObjectFromFile("./src/test/resources/json/nonexistent.json");
        assertNotNull(json);
        assertTrue(json.entrySet().isEmpty());
    }

    @Test
    @DisplayName("Should return null for non-existent file using loadJsonFromFile")
    void loadJsonFromFile_nonExistentFile() {
        var json = JsonFileReader.loadJsonFromFile("./src/test/resources/json/nonexistent.json");
        assertNull(json);
    }

    @Test
    @DisplayName("Should return empty string for non-existent file using loadJsonStringFromFile")
    void loadJsonStringFromFile_nonExistentFile() {
        var jsonString = JsonFileReader.loadJsonStringFromFile("./src/test/resources/json/nonexistent.json");
        assertNotNull(jsonString);
        assertTrue(jsonString.isEmpty());
    }

    @Test
    @DisplayName("Should return empty JsonObject for array file")
    void loadJsonObjectFromFile_arrayFile() {
        var json = JsonFileReader.loadJsonObjectFromFile("./src/test/resources/json/json_empty_test.json");
        assertNotNull(json);
        // Should be empty because it's not an object
        assertTrue(json.entrySet().isEmpty());
    }

    @Test
    @DisplayName("Should load JsonArray from file using loadJsonFromFile")
    void loadJsonFromFile_arrayFile() {
        var json = JsonFileReader.loadJsonFromFile("./src/test/resources/json/json_array_test.json");
        assertNotNull(json);
        assertInstanceOf(com.google.gson.JsonArray.class, json);
        var arr = (com.google.gson.JsonArray) json;
        assertEquals(3, arr.size());
        assertEquals("Item1", arr.get(0).getAsJsonObject().get("name").getAsString());
    }

    @Test
    @DisplayName("Should load JSON array string from file using loadJsonStringFromFile")
    void loadJsonStringFromFile_arrayFile() {
        var jsonString = JsonFileReader.loadJsonStringFromFile("./src/test/resources/json/json_array_test.json");
        assertNotNull(jsonString);
        assertTrue(jsonString.startsWith("["));
        assertTrue(jsonString.contains("Item2"));
        assertTrue(jsonString.contains("value"));
    }
}