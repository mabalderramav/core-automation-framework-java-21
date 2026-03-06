package com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson;

import com.miasoftnanus.automation.core.environment.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Utility class that provides methods for mapping user-related data structures
 * such as converting between {@link UserGsonEntity} and {@link User} model objects.
 * This class simplifies the transformation of data between entities and models used
 * within the application.
 */
class UserMapper {

    /**
     * A utility class that provides methods for mapping user-related data
     * structures, typically for converting entity representations to models or
     * vice versa.
     * <p>
     * This class is not intended to be instantiated. The constructor is private
     * to enforce its utility nature.
     */
    private UserMapper() {
        // Prevent instantiation.
    }

    /**
     * Converts a {@link UserGsonEntity} object to an {@link Optional} containing a {@link User} model object.
     * If the input entity is null, an empty {@link Optional} is returned.
     *
     * @param entity the {@link UserGsonEntity} object to be converted. Maybe null.
     * @return an {@link Optional} containing the converted {@link User} model object,
     *         or an empty {@link Optional} if the input entity is null.
     */
    static Optional<User> toModel(final UserGsonEntity entity) {
        if (entity == null) {
            return Optional.empty();
        }

        final User model = new User();
        model.type(entity.type());
        model.username(entity.username());
        model.password(entity.password());
        model.token(entity.token());
        return Optional.of(model);
    }

    /**
     * Converts a list of {@link UserGsonEntity} objects to a list of {@link User} model objects.
     * Only non-null {@link User} objects are included in the resulting list.
     *
     * @param entities the list of {@link UserGsonEntity} objects to be converted.
     *                 Each entity is processed to generate an equivalent {@link User} model.
     * @return a list of {@link User} model objects corresponding to the input entities.
     *         The list excludes null values and ensures only valid users are included.
     */
    static List<User> toModel(final List<UserGsonEntity> entities) {
        return entities.stream()
                .map(UserMapper::toModel)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
