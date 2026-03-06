package com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson;

import com.miasoftnanus.automation.core.environment.model.Authentication;

import java.util.List;
import java.util.Optional;

/**
 * Utility class that provides methods for mapping authentication-related data structures
 * such as converting between {@link AuthenticationGsonEntity} and {@link Authentication} model objects.
 * This class simplifies the transformation of data between entities and models in the application.
 * <p>
 * This class is not intended to be instantiated. The constructor is private to enforce its utility nature.
 * </p>
 */
class AuthenticationMapper {

    /**
     * Private constructor to prevent instantiation of the {@code AuthenticationMapper} utility class.
     * The {@code AuthenticationMapper} is designed to provide static methods for mapping authentication-related
     * data structures, such as converting between {@link AuthenticationGsonEntity} and {@link Authentication}
     * model objects.
     */
    private AuthenticationMapper() {
        // Prevent instantiation.
    }

    /**
     * Converts an {@link AuthenticationGsonEntity} object to an {@link Optional} containing an {@link Authentication} model object.
     * If the input entity is null, an empty {@link Optional} is returned.
     *
     * @param entity the {@link AuthenticationGsonEntity} object to be converted. Maybe null.
     * @return an {@link Optional} containing the converted {@link Authentication} model object,
     * or an empty {@link Optional} if the input entity is null.
     */
    static Optional<Authentication> toModel(final AuthenticationGsonEntity entity) {
        if (entity == null) {
            return Optional.empty();
        }

        Authentication model = new Authentication();
        model.type(entity.type());
        model.users(UserMapper.toModel(entity.users()));

        return Optional.of(model);
    }

    /**
     * Converts a list of {@link AuthenticationGsonEntity} objects to a list of {@link Authentication} model objects.
     * Each {@link AuthenticationGsonEntity} is mapped to an {@link Authentication}, and null or invalid values
     * are excluded from the resulting list.
     *
     * @param entities the list of {@link AuthenticationGsonEntity} objects to be converted.
     *                 Each entity is processed to generate an equivalent {@link Authentication} model.
     * @return a list of {@link Authentication} model objects corresponding to the input entities.
     * The list excludes null and invalid values, ensuring only valid {@link Authentication} objects are included.
     */
    static List<Authentication> toModel(final List<AuthenticationGsonEntity> entities) {
        return entities.stream()
                .map(AuthenticationMapper::toModel)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
