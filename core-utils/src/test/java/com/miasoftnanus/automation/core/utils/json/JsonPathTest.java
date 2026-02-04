package com.miasoftnanus.automation.core.utils.json;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.jsonpath.PathNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonPathTest {

    private static String readTestJson() throws Exception {
        return new String(Files.readAllBytes(Paths.get("src/test/resources/json/jsonpath_test.json")));
    }

    private static JsonObject readTestJsonObject() throws Exception {
        return JsonParser.parseString(readTestJson()).getAsJsonObject();
    }

    @Test
    @DisplayName("Test getResults method")
    void getResults() throws Exception {
        JsonObject json = readTestJsonObject();
        List<String> authors = JsonPath.getResults(json, "$.store.book[*].author");
        assertNotNull(authors);
        assertEquals(4, authors.size());
        assertTrue(authors.contains("Nigel Rees"));
    }

    @Test
    @DisplayName("Test getResultsBoolean method")
    void getResultsBoolean() throws Exception {
        JsonObject json = readTestJsonObject();
        List<Boolean> prices = JsonPath.getResultsBoolean(json, "$.store.book[?(@.price > 10)].enabled");
        assertNotNull(prices);
        assertEquals(2, prices.size());
    }

    @Test
    @DisplayName("Test getResult method")
    void getResult() throws Exception {
        String json = readTestJson();
        String author = JsonPath.getResult(json, "$.store.book[0].author");
        assertEquals("Nigel Rees", author);
    }

    @Test
    @DisplayName("Test setValue method")
    void setValue() throws Exception {
        JsonObject json = readTestJsonObject();
        String updated = JsonPath.setValue(json, "$.store.bicycle.color", "blue");
        assertTrue(updated.contains("blue"));
        assertTrue(updated.contains("bicycle"));
    }

    @Test
    @DisplayName("Test getResult method with invalid path")
    void getResult_pathNotFound() throws Exception {
        String json = readTestJson();
        assertThrows(PathNotFoundException.class, () -> JsonPath.getResult(json, "$.store.book[10].author"));
    }
}