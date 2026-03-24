package com.miasoftnanus.automation.core.ui.adapter.out.infrastructure.selenium.browser;

import com.miasoftnanus.automation.core.configuration.properties.bootstrap.UiConfigManager;
import lombok.Data;
import lombok.experimental.Accessors;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.BROWSER_ARGS_SIDE_NAVIGATION;
import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.DISABLE_BLINK_FEATURES_AUTOMATION_CONTROLLED;
import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.DISABLE_WEB_SECURITY;
import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.ENABLE_AUTOMATION;
import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.EXCLUDE_SWITCHES;
import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.INCOGNITO_MODE;
import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.LOGGING_PREFS;
import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.PREFS;
import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.REMOTE_ALLOW_ORIGINS;
import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.USE_AUTOMATION_EXTENSION;

/**
 * Represents an abstract base class for managing a Chrome browser instance with specific configurations.
 * The configurations include browser preferences, logging preferences, and capabilities to customize
 * the behavior of the Chrome browser during automated workflows.
 * <p>
 * This class initializes a configured instance of {@link ChromeOptions} upon creation, ensuring
 * consistent browser settings across subclasses. It provides a foundation for additional functionality
 * related to Chrome-based web automation.
 * <p>
 * <p>
 * Key features include:
 * - Setting experimental options and browser arguments to control Chrome behavior.
 * - Enabling logging preferences for enhanced monitoring and debugging.
 * - Managing download paths based on the browser type.
 * - Supporting optional incognito mode for browsing privacy.
 * - Accepting insecure certificates for development and testing environments.
 * </p>
 * <p>
 * Subclasses must extend this class to leverage its pre-configured options and methods for Chrome automation.
 * </p>
 */
@Data
@Accessors(fluent = true)
public abstract class Chrome {
    protected final ChromeOptions options;


    /**
     * Constructor for the {@code Chrome} class. This method initializes the Chrome browser
     * configuration by setting up the required ChromeOptions. The configuration includes
     * preferences, experimental options, and other customization to manage browser behavior.
     * <p>
     * The ChromeOptions instance is built using the {@code buildChromeOptions()} method,
     * which performs the following:
     * - Sets preferences for downloads and popups.
     * - Configures experimental options such as disabling automation extensions and
     * web security settings.
     * - Enables incognito mode if specified in the configuration.
     * - Integrates logging preferences for browser logs based on configuration flags.
     * - Specifies additional browser arguments for navigation and performance optimization.
     * </p>
     * <p>
     * This constructor ensures that all necessary configurations are applied before the
     * Chrome browser instance is used.
     * </p>
     */
    protected Chrome() {
        var uiConfig = UiConfigManager.getInstance().uiConfig();
        options = new ChromeOptions();
        options.setExperimentalOption(PREFS.val(), ChromeOptionsHelper.getPrefsMap());
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.setCapability(ChromeOptions.CAPABILITY, options);
        if (uiConfig.isBrowserLogsEnabled()) {
            options.setCapability(LOGGING_PREFS.val(), ChromeOptionsHelper.getLoggingPreferences());
        }

        options.addArguments(BROWSER_ARGS_SIDE_NAVIGATION.val());
        options.addArguments(DISABLE_BLINK_FEATURES_AUTOMATION_CONTROLLED.val());
        options.addArguments(REMOTE_ALLOW_ORIGINS.val());
        options.addArguments(DISABLE_WEB_SECURITY.val());
        if (uiConfig.isIncognitoMode()) {
            options.addArguments(INCOGNITO_MODE.val());
        }

        options.setExperimentalOption(EXCLUDE_SWITCHES.val(), ENABLE_AUTOMATION.val());
        options.setExperimentalOption(USE_AUTOMATION_EXTENSION.val(), false);
    }
}
