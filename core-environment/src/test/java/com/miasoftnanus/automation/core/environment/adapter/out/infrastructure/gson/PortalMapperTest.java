package com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson;

import com.miasoftnanus.automation.core.environment.model.Portal;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PortalMapperTest {

    @Test
    void tolModel_NullEntity_ReturnsEmptyOptional() {
        // Act
        Optional<Portal> result = PortalMapper.tolModel((PortalGsonEntity) null);

        // Assert
        assertTrue(result.isEmpty(), "Expected Optional to be empty when input entity is null");
    }

    @Test
    void tolModel_ValidEntity_ReturnsPopulatedOptionalAndMapsFields() {
        // Arrange
        UserGsonEntity user = new UserGsonEntity()
                .type("DEFAULT")
                .username("john")
                .password("secret")
                .token("token-123");

        PortalGsonEntity entity = new PortalGsonEntity()
                .name("MyPortal")
                .loginUrl("https://example.test/login")
                .baseUrl("https://example.test")
                .users(List.of(user));

        // Act
        Optional<Portal> result = PortalMapper.tolModel(entity);

        // Assert
        assertTrue(result.isPresent(), "Expected Optional to contain a value for a valid entity");
        Portal portal = result.get();

        assertEquals("MyPortal", portal.name(), "Portal name should match the entity name");
        assertEquals("https://example.test/login", portal.loginUrl(), "Portal loginUrl should match the entity loginUrl");
        assertEquals("https://example.test", portal.baseUrl(), "Portal baseUrl should match the entity baseUrl");

        assertNotNull(portal.users(), "Users list should not be null");
        assertEquals(1, portal.users().size(), "Users list size should match");
        assertEquals("DEFAULT", portal.users().getFirst().type(), "User type should match");
        assertEquals("john", portal.users().getFirst().username(), "Username should match");
        assertEquals("secret", portal.users().getFirst().password(), "Password should match");
        assertEquals("token-123", portal.users().getFirst().token(), "Token should match");
    }

    @Test
    void tolModel_NullList_ReturnsEmptyList() {
        // Act
        List<Portal> result = PortalMapper.tolModel((List<PortalGsonEntity>) null);

        // Assert
        assertNotNull(result, "Expected a non-null list when input list is null");
        assertTrue(result.isEmpty(), "Expected an empty list when input list is null");
    }

    @Test
    void tolModel_EmptyList_ReturnsEmptyList() {
        // Act
        List<Portal> result = PortalMapper.tolModel(List.of());

        // Assert
        assertNotNull(result, "Expected a non-null list when input list is empty");
        assertTrue(result.isEmpty(), "Expected an empty list when input list is empty");
    }

    @Test
    void tolModel_ListWithNullElements_FiltersNulls() {
        // Arrange
        PortalGsonEntity valid = new PortalGsonEntity()
                .name("Valid")
                .loginUrl("http://localhost/login")
                .baseUrl("http://localhost")
                .users(List.of());

        List<PortalGsonEntity> entities = Arrays.asList(null, valid, null);

        // Act
        List<Portal> result = PortalMapper.tolModel(entities);

        // Assert
        assertEquals(1, result.size(), "Expected only non-null entities to be mapped");
        assertEquals("Valid", result.getFirst().name(), "Mapped portal should come from the valid entity");
    }
}

