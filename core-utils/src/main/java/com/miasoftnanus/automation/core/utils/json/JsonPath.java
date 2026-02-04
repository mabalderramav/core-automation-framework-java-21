package com.miasoftnanus.automation.core.utils.json;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import com.jayway.jsonpath.spi.mapper.GsonMappingProvider;

import java.util.List;

/**
 * Utility class for JSON path operations using Jayway JsonPath with Gson integration.
 */
public final class JsonPath {
    private JsonPath() {
    }

    /**
     * Gets of a filter result.
     *
     * @param jsonContent    the JSON object.
     * @param jsonPathFilter Filter expression. Expression must evaluate to a boolean value.
     * @return filter result.
     */
    public static List<String> getResults(final JsonObject jsonContent, final String jsonPathFilter) {
        Configuration conf = Configuration.builder()
                .jsonProvider(new GsonJsonProvider())
                .mappingProvider(new GsonMappingProvider())
                .build();
        JsonArray jsonArray = com.jayway.jsonpath.JsonPath.using(conf).parse(jsonContent).read(jsonPathFilter);
        return new Gson().fromJson(jsonArray, new TypeToken<List<String>>(){}.getType());
    }

    /**
     * Gets of a filter result as boolean.
     *
     * @param jsonContent    the JSON object.
     * @param jsonPathFilter Filter expression. Expression must evaluate to a boolean value.
     * @return filter result.
     */
    public static List<Boolean> getResultsBoolean(final JsonObject jsonContent, final String jsonPathFilter) {
        Configuration conf = Configuration.builder()
                .jsonProvider(new GsonJsonProvider())
                .mappingProvider(new GsonMappingProvider())
                .build();
        JsonArray jsonArray = com.jayway.jsonpath.JsonPath.using(conf).parse(jsonContent).read(jsonPathFilter);
        return new Gson().fromJson(jsonArray, new TypeToken<List<Boolean>>(){}.getType());
    }

    /**
     * Gets of a filter result.
     *
     * @param jsonContent   the JSON string.
     * @param jsonPathFiler Filter expression.
     * @return filter results.
     */
    public static <T> T getResult(final String jsonContent, final String jsonPathFiler) {
        try {
            return com.jayway.jsonpath.JsonPath.parse(jsonContent).read(jsonPathFiler);
        } catch (PathNotFoundException e) {
            throw new PathNotFoundException(e.getMessage(), e);
        }
    }

    /**
     * Gets new JSON string with the new values.
     *
     * @param jsonContent   the JSON object.
     * @param jsonPathFiler Filter expression.
     * @param valueToSet    to set.
     * @return new JSON string with the new values.
     */
    public static String setValue(final JsonObject jsonContent, final String jsonPathFiler, final Object valueToSet) {
        Configuration conf = Configuration.builder()
                .jsonProvider(new GsonJsonProvider())
                .mappingProvider(new GsonMappingProvider())
                .build();
        return com.jayway.jsonpath.JsonPath.using(conf).parse(jsonContent).set(jsonPathFiler, valueToSet).jsonString();
    }
}
