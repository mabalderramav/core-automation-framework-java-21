package com.miasoftnanus.automation.core.ui.adapter.out.infrastructure.selenium.browser;

import org.openqa.selenium.WebDriver;

/**
 * Represents a contract for browser implementations to provide WebDriver instances.
 * <p>
 * Implementing classes are responsible for configuring and returning a WebDriver
 * instance corresponding to a specific browser type. This abstraction allows for
 * integration with various browser drivers and their respective configurations.
 * </p>
 */
public interface Browser {

    /**
     * Retrieves an instance of {@link WebDriver} configured for the specific browser implementation.
     * <p>
     * Implementing classes are responsible for providing the configured WebDriver instance, ensuring
     * that it adheres to the required browser type and its associated configuration settings.
     *
     * @return a configured {@link WebDriver} instance for browser automation.
     */
    WebDriver getDriver();
}
