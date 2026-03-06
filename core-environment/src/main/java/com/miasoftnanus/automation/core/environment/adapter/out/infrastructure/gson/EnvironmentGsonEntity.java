package com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Represents an environment entity with details about associated portals and APIs.
 * This class is designed for use with Gson, leveraging annotations for JSON serialization
 * and deserialization.
 * <p>
 * Key fields:
 * - {@code name}: The name of the environment, represented in JSON by the property "Name".
 * - {@code portals}: A list of {@link PortalGsonEntity} objects, representing various portals
 *   in the environment. This is represented in JSON by the property "Portals".
 * - {@code apis}: A list of {@link ApiGsonEntity} objects, representing APIs available
 *   in the environment. This is represented in JSON by the property "Apis".
 * </p>
 * <p>
 * Gson annotations used:
 * - {@code @SerializedName}: Maps the field to the specified JSON property name.
 * - {@code @Expose}: Indicates the field should be included in JSON serialization and deserialization.
 * </p>
 * <p>
 * This class also leverages Lombok annotations to simplify coding:
 * - {@code @Data}: Automatically generates standard methods such as getters, setters,
 *   equals, hashCode, and toString.
 * - {@code @Accessors(fluent = true)}: Configures Lombok to use fluent-style accessors
 *   for the generated methods.
 * </p>
 */
@Data
@Accessors(fluent = true)
class EnvironmentGsonEntity {
    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("Portals")
    @Expose
    private List<PortalGsonEntity> portals;

    @SerializedName("Apis")
    @Expose
    private List<ApiGsonEntity> apis;
}
