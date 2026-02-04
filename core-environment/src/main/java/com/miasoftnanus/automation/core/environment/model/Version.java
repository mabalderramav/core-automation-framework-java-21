package com.miasoftnanus.automation.core.environment.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Represents a version with a name and version identifier.
 * <p>
 * This class provides a structure for encapsulating version-related information
 * such as a version name and its corresponding version identifier. Instances of
 * this class are commonly used for defining version details in a broader context,
 * such as in API configurations.
 * </p>
 */
@Data
@Accessors(fluent = true)
public class Version {
    private String name;
    private String pathVersion;

    /**
     * Initializes an instance of {@link Version}.
     */
    public Version() {
        this.name = ReservedWords.EMPTY_STRING.val();
        this.pathVersion = ReservedWords.EMPTY_STRING.val();
    }
}
