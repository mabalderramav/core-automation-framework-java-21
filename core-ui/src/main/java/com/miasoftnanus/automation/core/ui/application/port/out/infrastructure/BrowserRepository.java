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
}
