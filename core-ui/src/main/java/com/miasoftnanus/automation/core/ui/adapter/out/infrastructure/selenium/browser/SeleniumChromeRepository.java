package com.miasoftnanus.automation.core.ui.adapter.out.infrastructure.selenium.browser;

import com.miasoftnanus.automation.core.ui.application.port.out.infrastructure.BrowserRepository;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;

/**
 * Implementation of the {@link BrowserRepository} interface that leverages the Selenium WebDriver
 * for browser automation. This class interacts with a provided {@link Browser} implementation
 * to perform browser actions such as opening URLs or navigating to specific locations.
 * <p>
 * This implementation is tailored for Chrome-based browser automation and relies on a configured
 * instance of {@link WebDriver} provided by the {@link Browser} object to carry out its tasks.
 * It is designed to abstract the low-level WebDriver interactions and provide a higher-level
 * interface for browser-related operations.
 * <p>
 * <p>
 * Responsibilities of this class include:
 * - Opening a specified URL in a Chrome browser instance.
 * - Navigating to a new specified URL in the Chrome browser.
 * </p>
 */
@RequiredArgsConstructor
public class SeleniumChromeRepository implements BrowserRepository {
    private final Browser browser;

    /**
     * {@inheritDoc}
     */
    @Override
    public void open(String url) {
        browser.getDriver().get(url);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void navigateTo(String url) {
        browser.getDriver().navigate().to(url);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() {
        browser.getDriver().quit();
    }
}
