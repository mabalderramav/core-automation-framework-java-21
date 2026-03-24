package com.miasoftnanus.automation.core.ui.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Represents supported browser types for use in UI automation or application configuration.
 * This enumeration provides a predefined set of constants to identify browser types
 * and their corresponding string representations.
 * <p>
 * Each browser type is associated with a specific value that can be used for configuration
 * or runtime decision-making when interacting with browser-specific settings or behaviors.
 * </p>
 * <p>
 * Enum Constants:
 * - CHROME: Represents the Google Chrome browser.
 * - FIREFOX: Represents the Mozilla Firefox browser.
 * - EDGE: Represents the Microsoft Edge browser.
 * - SAFARI: Represents the Apple Safari browser.
 * </p>
 * <p>
 * This enum is designed to be immutable and ensures type safety when dealing with
 * browser-specific identification.
 * </p>
 */
@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor
public enum BrowserTypes {
    CHROME("Chrome"),
    FIREFOX("Firefox"),
    EDGE("Edge"),
    SAFARI("Safari");

    private final String val;
}
