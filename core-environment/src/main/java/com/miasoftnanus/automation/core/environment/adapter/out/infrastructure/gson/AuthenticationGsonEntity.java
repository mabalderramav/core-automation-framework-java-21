package com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Represents an authentication entity used for JSON serialization and deserialization.
 * This class is primarily used for mapping authentication data from JSON format into
 * Java objects using Gson and vice versa.
 * <p>
 * The {@code AuthenticationGsonEntity} is composed of two primary elements:
 * - The authentication type, which is a string.
 * - A list of user entities, represented by {@link UserGsonEntity}.
 * </p>
 * <p>
 * Annotations {@code @SerializedName} and {@code @Expose} are used to specify the
 * mapping between JSON fields and the Java object properties, ensuring seamless
 * serialization and deserialization using Gson.
 * </p>
 * <p>
 * The class is annotated with Lombok's {@code @Data} to generate boilerplate code,
 * such as getters, setters, and other utility methods, while {@code @Accessors(fluent = true)}
 * streamlines method naming for fluent-style accessors.
 * </p>
 */
@Data
@Accessors(fluent = true)
class AuthenticationGsonEntity {
    @SerializedName("Type")
    @Expose
    private String type;

    @SerializedName("Users")
    @Expose
    private List<UserGsonEntity> users;
}
