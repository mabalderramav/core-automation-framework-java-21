package com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson;

import com.miasoftnanus.automation.core.environment.model.Portal;

import java.util.List;
import java.util.Optional;

class PortalMapper {

    /**
     * A utility class for mapping between different portal-related data structures,
     * often used for converting entities to models or vice versa.
     * <p>This class is not meant to be instantiated. The constructor is private
     * to enforce its utility nature.</p>
     */
    private PortalMapper() {
        // Prevent instantiation.
    }

    /**
     * Converts a {@link PortalGsonEntity} object into an {@link Optional} containing a {@link Portal} model object.
     * If the input entity is null, an empty {@link Optional} is returned.
     *
     * @param entity the {@link PortalGsonEntity} object to be converted. Maybe null.
     * @return an {@link Optional} containing the converted {@link Portal} model object,
     * or an empty {@link Optional} if the input entity is null.
     */
    static Optional<Portal> tolModel(final PortalGsonEntity entity) {
        if (entity == null) {
            return Optional.empty();
        }

        var model = new Portal();
        model.name(entity.name());
        model.loginUrl(entity.loginUrl());
        model.baseUrl(entity.baseUrl());
        model.users(UserMapper.toModel(entity.users()));

        return Optional.of(model);
    }

    /**
     * Converts a list of {@link PortalGsonEntity} objects to a list of {@link Portal} model objects.
     * Each {@link PortalGsonEntity} is mapped to a {@link Portal}, and null values are excluded.
     * Only valid {@link Portal} objects are included in the resulting list.
     *
     * @param entities the list of {@link PortalGsonEntity} objects to be converted.
     *                 Each entity is processed to generate an equivalent {@link Portal} model.
     * @return a list of {@link Portal} model objects corresponding to the input entities.
     * The list excludes null values and ensures only valid portals are included.
     */
    static List<Portal> tolModel(final List<PortalGsonEntity> entities) {
        if (entities == null) {
            return List.of();
        }
        return entities.stream()
                .map(PortalMapper::tolModel)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
