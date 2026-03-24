package com.miasoftnanus.automation.core.ui.adapter.out.infrastructure.selenium.browser;

import com.miasoftnanus.automation.core.configuration.properties.bootstrap.UiConfigManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

/**
 * Represents a Chrome browser implementation that runs locally with specific configurations
 * inherited from the {@code Chrome} base class. This class integrates with the WebDriverManager
 * library to manage the lifecycle of the Chrome WebDriver.
 * <p>
 * ChromeLocally is responsible for retrieving an instance of {@link WebDriver} configured for
 * local execution. The class supports flexible WebDriver version configuration and is built
 * on the foundation of the pre-configured {@code ChromeOptions} from the super class.
 * </p>
 * <p>
 * Key features:
 * - Manages the lifecycle of the ChromeDriver for local execution.
 * - Supports optional specification of the WebDriver version.
 * - Utilizes pre-configured ChromeOptions for consistent browser behavior.
 * - Implements the {@code Browser} interface to provide a WebDriver instance.
 * </p>
 */
public class ChromeLocally extends Chrome implements Browser {


    /**
     * Default constructor for the {@code ChromeLocally} class. This constructor initializes
     * a locally running Chrome browser instance with the pre-configured {@code ChromeOptions}
     * inherited from the {@code Chrome} base class.
     * <p>
     * The constructor ensures that all necessary configurations for the Chrome browser are
     * inherited and properly set up before use, such as browser preferences, experimental
     * options, and capabilities, enabling seamless instantiation for local browser automation.
     * </p>
     */
    public ChromeLocally() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getDriver() {
        var browserVersion = UiConfigManager.getInstance().uiConfig().driverVersion();
        if (Objects.nonNull(browserVersion) && !browserVersion.isEmpty())
            return WebDriverManager.chromedriver().driverVersion(browserVersion).capabilities(options).create();

        return WebDriverManager.chromedriver().capabilities(options).create();
    }
}
