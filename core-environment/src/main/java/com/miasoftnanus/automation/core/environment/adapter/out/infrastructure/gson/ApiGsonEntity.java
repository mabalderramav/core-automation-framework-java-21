package com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Represents an API entity using Gson annotations for JSON serialization and deserialization.
 * <p>
 * This class defines the structure of an API entity, which includes properties
 * such as its name, base URL, supported versions, and authentication methods.
 * Each field uses Gson annotations to map JSON properties with the corresponding
 * class members.
 * <p>
 * The annotations used in this class include:
 * - {@code @SerializedName}: Defines the JSON property name corresponding to the field.
 * - {@code @Expose}: Indicates that the field should be included in serialization and deserialization.
 * </p>
 * <p>
 * Key fields:
 * - {@code name}: The name of the API, as represented in JSON by the property "Name".
 * - {@code baseUrl}: The base URL of the API, as represented in JSON by the property "BaseUrl".
 * - {@code versions}: A list of supported versions of the API, represented by {@link VersionGsonEntity}.
 * - {@code authentications}: A list of authentication methods, represented by {@link AuthenticationGsonEntity}.
 * </p>
 * <p>
 * This class leverages Lombok annotations to reduce boilerplate code:
 * - {@code @Data}: Automatically generates common methods such as getters, setters, equals, hashCode, and toString.
 * - {@code @Accessors(fluent = true)}: Configures Lombok to use a fluent API style for generated accessor methods.
 * </p>
 */
@Data
@Accessors(fluent = true)
class ApiGsonEntity {
    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("BaseUrl")
    @Expose
    private String baseUrl;

    @SerializedName("Versions")
    @Expose
    private List<VersionGsonEntity> versions;

    @SerializedName("Authentications")
    @Expose
    private List<AuthenticationGsonEntity> authentications;
}
