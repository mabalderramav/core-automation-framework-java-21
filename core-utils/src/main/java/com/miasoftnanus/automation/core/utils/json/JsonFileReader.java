package com.miasoftnanus.automation.core.utils.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Reads data from .json file.
 */
@Log4j2
public final class JsonFileReader {
    private static final String ENCODING = "UTF-8";

    /**
     * Initializes an instance of {@link JsonFileReader}.
     */
    private JsonFileReader() {
    }

    /**
     * Loads content from a JSON file and returns it as JSONObject.
     *
     * @param jsonFilePath the path of the JSON file.
     * @return json object.
     */
    public static JsonObject loadJsonObjectFromFile(final String jsonFilePath) {
        JsonObject jsonObject = new JsonObject();
        String jsonPath = jsonFilePath;
        if (!new File(jsonFilePath).exists()) {
            jsonPath = jsonFilePath.replace(ReservedWords.DOUBLE_DOT_AND_SLASH.val(),
                    ReservedWords.STRING_EMPTY.val());
        }
        try (InputStreamReader inputFile = new InputStreamReader(new FileInputStream(jsonPath), ENCODING)) {
            jsonObject = (JsonObject) JsonParser.parseReader(inputFile);
        } catch (IOException e) {
            log.warn("Problem while reading the file", e);
        }
        return jsonObject;
    }

    /**
     * Loads content from a JSON file and returns it as a JSON object.
     *
     * @param jsonFilePath the path of the JSON file.
     * @return json object.
     */
    public static Object loadJsonFromFile(final String jsonFilePath) {
        Object jsonContent = null;
        String jsonPath = jsonFilePath;
        if (!new File(jsonFilePath).exists()) {
            jsonPath = jsonFilePath.replace(ReservedWords.DOUBLE_DOT_AND_SLASH.val(),
                    ReservedWords.STRING_EMPTY.val());
        }
        try (InputStreamReader inputFile = new InputStreamReader(new FileInputStream(jsonPath), ENCODING)) {
            jsonContent = JsonParser.parseReader(inputFile);
        } catch (IOException e) {
            log.warn("Problem while reading the file", e);
        }
        return jsonContent;
    }

    /**
     * Loads content from a JSON file and returns it as a JSON string.
     *
     * @param jsonFilePath the path of the JSON file.
     * @return json string.
     */
    public static String loadJsonStringFromFile(final String jsonFilePath) {
        Object jsonContent = loadJsonFromFile(jsonFilePath);
        if (jsonContent instanceof JsonObject) {
            return jsonContent.toString();
        } else if (jsonContent instanceof JsonArray) {
            return jsonContent.toString();
        } else {
            log.warn("Unexpected JSON content type");
            return "";
        }
    }
}
