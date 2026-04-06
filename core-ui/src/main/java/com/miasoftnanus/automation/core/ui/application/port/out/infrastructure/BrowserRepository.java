package com.miasoftnanus.automation.core.ui.application.port.out.infrastructure;

/**
 * This interface represents a repository for browser actions.
 * It provides a method to open a specific URL in a browser.
 */
public interface BrowserRepository {
    /**
     * Opens the specified URL in a browser.
     *
     * @param url the URL to be opened.
     */
    void open(String url);

    /**
     * Navigates to the specified URL.
     *
     * @param url the URL to navigate to.
     */
    void navigateTo(String url);

    /**
     * Closes the currently active browser session.
     */
    void close();
}
