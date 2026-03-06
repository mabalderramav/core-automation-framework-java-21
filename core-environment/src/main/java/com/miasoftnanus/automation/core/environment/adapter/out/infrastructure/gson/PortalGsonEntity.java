package com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Represents a portal entity with associated metadata and user information.
 * This class is designed to work with the Gson library to facilitate JSON serialization
 * and deserialization for portal-related data structures.
 * <p>
 * The entity contains information about a portal's name, login URL, base URL, and a list
 * of associated users. The fields are annotated with Gson annotations to map JSON properties
 * to class members accurately.
 * </p>
 * <p>
 * Annotations used:
 * - {@link SerializedName} to specify the JSON property names.
 * - {@link Expose} to control which fields are included in JSON serialization and deserialization.
 * </p>
 * <p>
 * This class is typically used in operations related to data persistence or API interaction where
 * portal-related information needs to be transformed between JSON structures and Java objects.
 * </p>
 */
@Data
@Accessors(fluent = true)
class PortalGsonEntity {
    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("LoginUrl")
    @Expose
    private String loginUrl;

    @SerializedName("BaseUrl")
    @Expose
    private String baseUrl;

    @SerializedName("Users")
    @Expose
    private List<UserGsonEntity> users;
}
