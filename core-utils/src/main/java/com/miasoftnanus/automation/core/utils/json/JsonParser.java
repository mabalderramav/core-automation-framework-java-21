package com.miasoftnanus.automation.core.utils.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Utility class providing methods for JSON parsing and serialization/deserialization.
 * This class uses the Gson library to handle JSON operations.
 * <p>
 * The class contains static methods for:
 * - Converting objects to JSON strings.
 * - Converting lists of objects to JSON strings.
 * - Deserializing JSON strings into objects.
 * - Deserializing JSON strings into lists of objects.
 * <p>
* This class is designed to prevent instantiation and should only be used via its static methods.
 */
public final class JsonParser {

    /**
     * Private constructor to prevent instantiation of the JsonParser class.
     * This class is designed to provide static utility methods for JSON parsing
     * and conversion, and therefore should not be instantiated.
     */
    private JsonParser() {
        // Default constructor.
    }

    /**
     * Converts an object to its JSON string representation using Gson.
     * Only fields annotated with @Expose will be included in the JSON output.
     * The JSON output is formatted with pretty printing.
     *
     * @param <T>         the type of the object to be converted to JSON
     * @param object      the object to convert to JSON format
     * @param entityClass the class of the object, used for serialization
     * @return a JSON string representation of the given object
     */
    public static <T> String toJsonString(final T object, final Class<T> entityClass) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        return gson.toJson(object, entityClass);
    }

    /**
     * Converts a list of objects to a JSON string representation.
     *
     * @param objectList  the list of objects to convert to JSON format
     * @param entityClass the class type of the objects in the list
     * @param <T>         the type of the objects in the list
     * @return a JSON string representing the list of objects
     */
    public static <T> String toJsonString(final List<T> objectList, final Class<T> entityClass) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        Type type = TypeToken.getParameterized(List.class, entityClass).getType();
        return gson.toJson(objectList, type);
    }

    /**
     * Deserializes a JSON string into an object of the specified class type.
     *
     * @param json        the JSON string to be deserialized.
     * @param entityClass the class of the object to which the JSON string should be deserialized.
     * @param <T>         the type of the resulting object.
     * @return an object of type T parsed from the input JSON string.
     * @throws com.google.gson.JsonSyntaxException if the JSON string is not a valid representation for an object of type T.
     */
    public static <T> T fromJsonString(final String json, final Class<T> entityClass) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.fromJson(json, entityClass);
    }

    /**
     * Converts a JSON string into an object of the specified type.
     *
     * @param json the JSON string to be deserialized.
     * @param type the type of the object to which the JSON string should be deserialized.
     * @param <T>  the type of the resulting object.
     * @return an object of type T parsed from the input JSON string.
     */
    public static <T> T fromJsonString(final String json, final Type type) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.fromJson(json, type);
    }

    /**
     * Converts a JSON string into a list of objects of the specified type.
     *
     * @param json        the JSON string to be converted.
     * @param entityClass the class of the objects contained in the resulting list.
     * @param <T>         the type of the objects in the list.
     * @return a list of objects of type T parsed from the input JSON string.
     */
    public static <T> List<T> fromJsonStringToList(final String json, final Class<T> entityClass) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Type type = TypeToken.getParameterized(List.class, entityClass).getType();
        return gson.fromJson(json, type);
    }
}
