package com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Represents a User data entity used for JSON mapping with Gson.
 * This class is typically used to deserialize/serialize user-related data
 * between JSON and Java objects. The fields of the class correspond to properties
 * in the JSON structure, and Gson annotations are used for handling field mapping.
 * <p>
 * Annotations used:
 * - {@link SerializedName} maps the JSON property names to the Java fields.
 * - {@link Expose} indicates that the fields can be serialized and deserialized.
 * </p>
 * <p>
 * Fields:
 * - type: The type of the user (e.g., Admin, Guest, etc.).
 * - username: The username associated with the user.
 * - password: The password for user authentication.
 * - token: An authentication token for the user, typically used for session management.
 * </p>
 * <p>
 * Note:
 * This class follows a fluent accessor style for getter and setter methods,
 * enabled by the {@link @Accessors(fluent = true)} annotation.
 * </p>
 */
@Data
@Accessors(fluent = true)
class UserGsonEntity {
    @SerializedName("Type")
    @Expose
    private String type;

    @SerializedName("Username")
    @Expose
    private String username;

    @SerializedName("Password")
    @Expose
    private String password;

    @SerializedName("Token")
    @Expose
    private String token;
}
