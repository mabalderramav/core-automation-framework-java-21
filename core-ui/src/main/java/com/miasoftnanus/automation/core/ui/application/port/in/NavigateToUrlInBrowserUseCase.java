package com.miasoftnanus.automation.core.ui.application.port.in;

/**
 * Represents a use case for navigating to a specific URL within a web browser.
 * This interface defines the contract for handling navigation operations.
 */
public interface NavigateToUrlInBrowserUseCase {

    /**
     * Navigates to the specified URL within a web browser.
     *
     * @param url the URL to navigate to; must be a valid and properly formatted string representing a web address.
     */
    void navigateTo(String url);
}
