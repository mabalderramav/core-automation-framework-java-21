package com.miasoftnanus.automation.core.ui.bootstrap.config;

import com.miasoftnanus.automation.core.utils.properties.PropertiesFileReader;
import lombok.Getter;
import lombok.Setter;

import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.BROWSER;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.BROWSER_LOGS;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.CHROME_DRIVER_VERSION;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.DOWNLOADS;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.ENVIRONMENT_NAME;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.EXPLICIT_TIME;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.GRADLE_PROP;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.HEIGHT;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.IMPLICIT_TIME;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.INCOGNITO_MODE;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.PAGE_LOAD_TIME;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.SELENIUM_HUB_PORT;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.SELENIUM_HUB_URL;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.SLEEP_TIME;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.UI_PROP_FILE;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.WIDTH;

public class UiConfig {
    @Setter
    private boolean browserLogsEnabled;
    @Getter
    private final String environment;
    @Getter
    public final int implicitTime;
    @Getter
    private final int explicitTime;
    @Getter
    private final int sleepTime;
    @Getter
    private final long pageLoadTime;
    @Getter
    private final String browser;
    @Getter
    private final String chromeDriverVersion;
    @Getter
    private final String downloadsFolder;
    @Getter
    private final int widthOfBrowser;
    @Getter
    private final int heightOfBrowser;
    @Getter
    private final String seleniumHubUrl;
    @Getter
    private final String seleniumHubPort;
    @Getter
    private final boolean isIncognitoMode;


    /**
     * Initializes an instance of {@link UiConfig}.
     */
    private UiConfig() {
        var propertiesFileReader = new PropertiesFileReader(GRADLE_PROP.val());
        var uiPropFilePath = propertiesFileReader.getPropertyValue(UI_PROP_FILE.val());
        var propertiesUiFileReader = new PropertiesFileReader(uiPropFilePath);
        browserLogsEnabled = Boolean.parseBoolean(propertiesUiFileReader.getPropertyValue(BROWSER_LOGS.val()));
        environment = propertiesUiFileReader.getPropertyValue(ENVIRONMENT_NAME.val());
        implicitTime = Integer.parseInt(propertiesUiFileReader.getPropertyValue(IMPLICIT_TIME.val()));
        explicitTime = Integer.parseInt(propertiesUiFileReader.getPropertyValue(EXPLICIT_TIME.val()));
        sleepTime = Integer.parseInt(propertiesUiFileReader.getPropertyValue(SLEEP_TIME.val()));
        browser = propertiesUiFileReader.getPropertyValue(BROWSER.val());
        pageLoadTime = Long.parseLong(propertiesUiFileReader.getPropertyValue(PAGE_LOAD_TIME.val()));
        chromeDriverVersion = propertiesUiFileReader.getPropertyValue(CHROME_DRIVER_VERSION.val());
        downloadsFolder = propertiesUiFileReader.getPropertyValue(DOWNLOADS.val());
        widthOfBrowser = Integer.parseInt(propertiesUiFileReader.getPropertyValue(WIDTH.val()));
        heightOfBrowser = Integer.parseInt(propertiesUiFileReader.getPropertyValue(HEIGHT.val()));
        seleniumHubUrl = propertiesUiFileReader.getPropertyValue(SELENIUM_HUB_URL.val());
        seleniumHubPort = propertiesUiFileReader.getPropertyValue(SELENIUM_HUB_PORT.val());
        isIncognitoMode = Boolean.parseBoolean(propertiesUiFileReader.getPropertyValue(INCOGNITO_MODE.val()));
    }

    /**
     * Holds the singleton instance of the {@code UiConfig} class.
     * This nested static class leverages the Java ClassLoader mechanism to ensure
     * thread-safe lazy initialization of the {@code UiConfig} instance.
     */
    private static class SingletonHolder {
        private static final UiConfig INSTANCE = new UiConfig();
    }

    /**
     * Returns the singleton instance of the {@code UiConfig} class.
     * This method ensures that only one instance of {@code UiConfig} is created and shared across the application.
     *
     * @return the singleton instance of {@code UiConfig}.
     */
    public static UiConfig getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * Gets browser logs.
     *
     * @return browser logs.
     */
    public boolean isBrowserLogEnable() {
        return browserLogsEnabled;
    }
}
