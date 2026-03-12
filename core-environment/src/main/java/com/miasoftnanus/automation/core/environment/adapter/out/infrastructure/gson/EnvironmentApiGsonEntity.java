package com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Represents an environment entity using Gson annotations for JSON serialization and deserialization.
 *
 * This class defines the structure of an environment entity, which includes the environment's name
 * and a list of associated APIs. Each API is represented by the {@link ApiGsonEntity} class.
 * Fields in this class are annotated with Gson's {@code @SerializedName} and {@code @Expose} annotations
 * to define JSON property mapping and serialization behavior.
 *
 * Key fields:
 * - {@code name}: The name of the environment, mapped to the JSON property "Name".
 * - {@code apis}: A list of APIs associated with this environment, each represented
 *   by the {@link ApiGsonEntity} class, and mapped to the JSON property "Apis".
 *
 * This class uses Lombok annotations to simplify common development tasks:
 * - {@code @Data}: Generates getters, setters, equals, hashCode, and toString methods automatically.
 * - {@code @Accessors(fluent = true)}: Enables fluent-style getter and setter methods.
 */
@Data
@Accessors(fluent = true)
class EnvironmentApiGsonEntity {
    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("Apis")
    @Expose
    private List<ApiGsonEntity> apis;
}
