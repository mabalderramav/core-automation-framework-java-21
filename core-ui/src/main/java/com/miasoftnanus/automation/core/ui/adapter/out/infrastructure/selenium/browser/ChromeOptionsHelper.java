package com.miasoftnanus.automation.core.ui.adapter.out.infrastructure.selenium.browser;

import com.miasoftnanus.automation.core.configuration.properties.bootstrap.UiConfigManager;
import com.miasoftnanus.automation.core.ui.model.WebDriverTypes;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.nio.file.Path;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.DOWNLOAD_DEFAULT_DIRECTORY;
import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.PROFILE_DEFAULT_CONTENT_SETTINGS_POPUPS;

/**
 * A utility class providing helper methods for configuring Chrome-specific options
 * used in WebDriver instances. This class is designed to facilitate the retrieval
 * of download paths, preferences for Chrome settings, and logging preferences.
 * It provides static methods for configuration, ensuring consistent and reusable
 * behavior across the application.
 *
 * <p>This class cannot be instantiated and is intended solely for static method usage.</p>
 */
final class ChromeOptionsHelper {

    /**
     * Private constructor for the {@code ChromeOptionsHelper} class.
     * This utility class is not designed to be instantiated and is intended
     * to provide static helper methods for configuring Chrome-specific WebDriver options.
     */
    private ChromeOptionsHelper() {
    }

    /**
     * Retrieves the download path for the specified WebDriver type.
     * The method uses a predefined mapping of WebDriver types to their respective
     * download paths. Paths are derived based on the configuration provided by
     * {@code UiConfigManager}.
     *
     * @param type the type of WebDriver for which the download path is requested.
     *             Supported types include {@code WebDriverTypes.CHROME},
     *             {@code WebDriverTypes.CHROME_DOCKER}, and {@code WebDriverTypes.CHROME_REMOTE}.
     * @return the absolute download path as a {@code String}, corresponding
     * to the specified WebDriver type, or {@code null} if no path is defined
     * for the given type.
     */
    static String getDownloadPath(WebDriverTypes type) {
        var downloadPathMap = new EnumMap<WebDriverTypes, String>(WebDriverTypes.class);
        var uiConfig = UiConfigManager.getInstance().uiConfig();
        downloadPathMap.put(WebDriverTypes.LOCALLY, Path.of(uiConfig.downloads()).toAbsolutePath().toString());
        downloadPathMap.put(WebDriverTypes.DOCKER, uiConfig.downloads());
        downloadPathMap.put(WebDriverTypes.REMOTE, uiConfig.downloads());
        return downloadPathMap.get(type);
    }

    /**
     * Constructs and returns a map containing Chrome-specific preferences for WebDriver configuration.
     * These preferences include settings such as disabling popups and defining the default download directory.
     * The configuration is dynamically determined based on the current UI configuration.
     *
     * @return a map of Chrome preferences where keys represent preference names as strings
     * and values represent the corresponding preference settings as objects.
     */
    static Map<String, Object> getPrefsMap() {
        HashMap<String, Object> chromePrefs = new HashMap<>();
        var uiConfig = UiConfigManager.getInstance().uiConfig();
        chromePrefs.put(PROFILE_DEFAULT_CONTENT_SETTINGS_POPUPS.val(), 0);
        chromePrefs.put(DOWNLOAD_DEFAULT_DIRECTORY.val(), getDownloadPath(WebDriverTypes.valueOf(uiConfig.browser())));
        return chromePrefs;
    }

    /**
     * Constructs and returns an instance of {@code LoggingPreferences} with predefined logging settings.
     * This method enables performance-related logs with the log level set to {@code Level.ALL}.
     *
     * @return a {@code LoggingPreferences} object configured to capture all performance-related logs.
     */
    static LoggingPreferences getLoggingPreferences() {
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.PERFORMANCE, Level.ALL);
        return loggingPreferences;
    }
}
