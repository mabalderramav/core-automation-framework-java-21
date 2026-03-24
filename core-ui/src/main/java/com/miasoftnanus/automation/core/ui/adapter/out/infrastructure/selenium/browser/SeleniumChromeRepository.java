package com.miasoftnanus.automation.core.ui.adapter.out.infrastructure.selenium.browser;

import com.miasoftnanus.automation.core.ui.application.port.out.infrastructure.BrowserRepository;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;

/**
 * An implementation of the {@link BrowserRepository} interface that uses a {@link Browser} instance
 * to automate browser actions specifically for Chrome.
 *
 * This class provides functionality to open a specified URL in a Chrome browser. It integrates with
 * a {@link Browser} implementation to retrieve a configured {@link WebDriver} for executing browser
 * automation tasks.
 *
 * Key responsibilities:
 * - Delegating the task of retrieving the appropriate {@link WebDriver} to the provided {@link Browser} instance.
 * - Automating the operation to navigate to a given URL.
 *
 * The {@code ChromeRepository} class relies on the dependency injection pattern, where a {@link Browser}
 * instance is required to be passed during its construction. This design ensures flexibility in providing
 * different browser configurations.
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
}
