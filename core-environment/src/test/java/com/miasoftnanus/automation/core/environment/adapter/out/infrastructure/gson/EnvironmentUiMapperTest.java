package com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson;

import com.miasoftnanus.automation.core.environment.model.EnvironmentUi;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EnvironmentUiMapperTest {

    @Test
    void toModel_NullEntity_ReturnsEmptyOptional() {
        // Act
        Optional<EnvironmentUi> result = EnvironmentUiMapper.toModel((EnvironmentUiGsonEntity) null);

        // Assert
        assertTrue(result.isEmpty(), "Expected Optional to be empty when input entity is null");
    }

    @Test
    void toModel_ValidEntity_ReturnsPopulatedOptionalAndMapsFields() {
        // Arrange
        UserGsonEntity user = new UserGsonEntity()
                .type("DEFAULT")
                .username("john")
                .password("secret")
                .token("token-123");

        PortalGsonEntity portal = new PortalGsonEntity()
                .name("Main")
                .loginUrl("https://example.test/login")
                .baseUrl("https://example.test")
                .users(List.of(user));

        EnvironmentUiGsonEntity entity = new EnvironmentUiGsonEntity()
                .name("QA")
                .portals(List.of(portal));

        // Act
        Optional<EnvironmentUi> result = EnvironmentUiMapper.toModel(entity);

        // Assert
        assertTrue(result.isPresent(), "Expected Optional to contain a value for a valid entity");
        EnvironmentUi env = result.get();

        assertEquals("QA", env.name(), "Environment name should match the entity name");
        assertNotNull(env.portals(), "Portals list should not be null");
        assertEquals(1, env.portals().size(), "Portals list size should match");

        assertEquals("Main", env.portals().getFirst().name(), "Portal name should match");
        assertEquals("https://example.test/login", env.portals().getFirst().loginUrl(), "Portal loginUrl should match");
        assertEquals("https://example.test", env.portals().getFirst().baseUrl(), "Portal baseUrl should match");

        assertNotNull(env.portals().getFirst().users(), "Users list should not be null");
        assertEquals(1, env.portals().getFirst().users().size(), "Users list size should match");
        assertEquals("john", env.portals().getFirst().users().getFirst().username(), "Username should match");
    }

    @Test
    @SuppressWarnings("DataFlowIssue")
    void toModel_NullList_ThrowsNullPointerException() {
        // Act + Assert
        assertThrows(NullPointerException.class,
                () -> EnvironmentUiMapper.toModel((List<EnvironmentUiGsonEntity>) null),
                "Expected NullPointerException because the contract states the input list must not be null");
    }

    @Test
    void toModel_EmptyList_ReturnsEmptyList() {
        // Act
        List<EnvironmentUi> result = EnvironmentUiMapper.toModel(List.of());

        // Assert
        assertNotNull(result, "Expected non-null list result");
        assertTrue(result.isEmpty(), "Expected empty result when input list is empty");
    }
}

