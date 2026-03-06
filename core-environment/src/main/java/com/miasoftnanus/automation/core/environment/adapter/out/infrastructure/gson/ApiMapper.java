package com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson;

import com.miasoftnanus.automation.core.environment.model.Api;

import java.util.List;
import java.util.Optional;

/**
 * Utility class for mapping {@link ApiGsonEntity} objects to {@link Api} model objects.
 * This class provides static methods to handle the conversion and ensures mapping logic
 * is centralized and reusable.
 *
 * <p>The constructor is private to prevent instantiation of this utility class.</p>
 */
class ApiMapper {

    /**
     * Private constructor to prevent instantiation of the {@code ApiMapper} utility class.
     * This class is designed to provide static methods for mapping {@link ApiGsonEntity} objects
     * to {@link Api} model objects and should not be instantiated.
     */
    private ApiMapper() {
        // Prevent instantiation.
    }

    /**
     * Converts an {@link ApiGsonEntity} object to an {@link Optional} containing an {@link Api} model object.
     * The method maps fields from the given {@link ApiGsonEntity} to their equivalent fields in the {@link Api} object.
     * If the input {@link ApiGsonEntity} is null, an empty {@link Optional} is returned.
     *
     * @param entity the {@link ApiGsonEntity} object to be converted. Maybe null.
     * @return an {@link Optional} containing the converted {@link Api} model object,
     * or an empty {@link Optional} if the input entity is null.
     */
    static Optional<Api> toApiModel(final ApiGsonEntity entity) {
        if (entity == null) {
            return Optional.empty();
        }

        final Api model = new Api();
        model.name(entity.name());
        model.baseUrl(entity.baseUrl());
        model.versions(VersionMapper.toModel(entity.versions()));
        model.authentications(AuthenticationMapper.toModel(entity.authentications()));

        return Optional.of(model);
    }

    /**
     * Converts a list of {@link ApiGsonEntity} objects to a list of {@link Api} model objects.
     * Each {@link ApiGsonEntity} is mapped to an {@link Api}, and null values are excluded.
     * Only valid {@link Api} objects are included in the resulting list.
     *
     * @param entities the list of {@link ApiGsonEntity} objects to be converted.
     *                 Each entity is processed to generate an equivalent {@link Api} model.
     * @return a list of {@link Api} model objects corresponding to the input entities.
     * The list excludes null values and ensures only valid APIs are included.
     */
    static List<Api> toApiModel(final List<ApiGsonEntity> entities) {
        if (entities == null) {
            return List.of();
        }
        return entities.stream()
                .map(ApiMapper::toApiModel)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
