package com.miasoftnanus.automation.core.utils.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Utility class for reading and processing content from JSON files.
 * This class includes methods to load JSON data as different types,
 * such as {@code JsonObject}, generic {@code Object}, or {@code String}.
 * It handles scenarios where the file path may initially be incorrect
 * by attempting to resolve relative paths and retrying.
 *
 * <p>This class is not intended to be instantiated.
 */
@Log4j2
public final class JsonFileReader {

    /**
     * Private constructor to prevent instantiation of the {@code JsonFileReader} class.
     * This class is designed to provide utility methods for reading and processing JSON files.
     * The constructor is intentionally private to enforce a static-only utility class pattern.
     */
    private JsonFileReader() {
    }

    /**
     * Loads a JSON object from the specified file path.
     * This method reads a JSON file, attempts to parse its content into
     * a {@link JsonObject}, and returns the resulting object.
     * If the file at the provided path does not exist, the method modifies
     * the path by removing "../" substrings and retries.
     *
     * @param jsonFilePath the path to the JSON file to be loaded.
     * @return a {@link JsonObject} containing the parsed JSON content,
     * or an empty {@link JsonObject} if an error occurs or the file cannot be found.
     */
    public static JsonObject loadJsonObjectFromFile(final String jsonFilePath) {
        JsonObject jsonObject = new JsonObject();
        String jsonPath = jsonFilePath;
        if (!new File(jsonFilePath).exists()) {
            jsonPath = jsonFilePath.replace(ReservedWords.DOUBLE_DOT_AND_SLASH.val(),
                    ReservedWords.STRING_EMPTY.val());
        }
        try (InputStreamReader inputFile = new InputStreamReader(new FileInputStream(jsonPath), StandardCharsets.UTF_8)) {
            jsonObject = (JsonObject) JsonParser.parseReader(inputFile);
        } catch (IOException e) {
            log.warn("Problem while reading the file", e);
        }
        return jsonObject;
    }

    /**
     * Loads content from a JSON file and returns it as a generic Object.
     * This method attempts to read the JSON file from the provided file path.
     * If the file does not exist at the specified path, it modifies the path
     * by removing "../" substrings and retries to locate the file.
     *
     * @param jsonFilePath the path to the JSON file to be loaded.
     * @return the content of the JSON file as an Object, or null if an error occurs or the file does not exist.
     */
    public static Object loadJsonFromFile(final String jsonFilePath) {
        Object jsonContent = null;
        String jsonPath = jsonFilePath;
        if (!new File(jsonFilePath).exists()) {
            jsonPath = jsonFilePath.replace(ReservedWords.DOUBLE_DOT_AND_SLASH.val(),
                    ReservedWords.STRING_EMPTY.val());
        }
        try (InputStreamReader inputFile = new InputStreamReader(new FileInputStream(jsonPath), StandardCharsets.UTF_8)) {
            jsonContent = JsonParser.parseReader(inputFile);
        } catch (IOException e) {
            log.warn("Problem while reading the file", e);
        }
        return jsonContent;
    }

    /**
     * Reads a JSON file and returns its content as a string.
     * If the content is a JSON object or array, it is returned as a string.
     * If the content is of an unexpected type, an empty string is returned.
     *
     * @param jsonFilePath the path to the JSON file to be loaded.
     * @return the content of the JSON file as a string, or an empty string if the content type is unexpected.
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
