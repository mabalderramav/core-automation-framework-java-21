package com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Represents an environment entity designed for mapping UI-related data structures,
 * particularly for use with the Gson library to handle JSON serialization and deserialization.
 * <p>
 * This class facilitates the representation of environment-level configurations,
 * specifically incorporating details such as the environment name and its associated
 * portals. Each portal is represented by a {@link PortalGsonEntity} instance.
 * <p>
 * Annotations:
 * - {@link SerializedName} is used to map JSON property names to the class fields.
 * - {@link Expose} denotes which fields will be included in both serialization
 * and deserialization processes.
 * </p>
 * <p>
 * Attributes:
 * - name: Represents the name of the environment.
 * - portals: A list of {@link PortalGsonEntity} objects representing the portals associated
 * with the environment.
 * </p>
 * <p>
 * The class is also annotated with Lombok annotations:
 * - {@link Data} generates getters, setters, equals, hashCode, and toString methods.
 * - {@link Accessors}(fluent = true) enables a fluent setter API for better readability.
 */
@Data
@Accessors(fluent = true)
class EnvironmentUiGsonEntity {
    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("Portals")
    @Expose
    private List<PortalGsonEntity> portals;
}
