package com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Represents an entity that encapsulates version-related information.
 * This class is designed to be used with Gson for JSON serialization and deserialization.
 * <p>
 * Each instance of this class contains details about a specific version,
 * including the version name and its associated version identifier.
 * </p>
 * <p>
 * Annotations:
 * - {@code @Data}: Generates boilerplate code such as getters, setters,
 *   equals, hashCode, and toString methods.
 * - {@code @Accessors(fluent = true)}: Configures the generated accessors
 *   to use a fluent interface style (e.g., `entity.name("value")`).
 * - {@code @SerializedName}: Maps the JSON field name to the class property for serialization purposes.
 * - {@code @Expose}: Marks the field as eligible for Gson's (de)serialization processing.
 * </p>
 */
@Data
@Accessors(fluent = true)
class VersionGsonEntity {
    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("Version")
    @Expose
    private String version;
}
