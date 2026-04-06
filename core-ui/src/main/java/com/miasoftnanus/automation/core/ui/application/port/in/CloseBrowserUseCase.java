package com.miasoftnanus.automation.core.ui.application.port.in;

/**
 * Represents a use case for closing a web browser.
 * This interface defines the contract for terminating the browser session or window.
 */
public interface CloseBrowserUseCase {
    /**
     * Closes the currently active web browser session or window.
     * This method is intended to terminate any ongoing browser activity
     * and perform necessary cleanup operations associated with the browser instance.
     */
    void close();
}
