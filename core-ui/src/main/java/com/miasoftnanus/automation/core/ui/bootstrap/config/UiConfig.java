package com.miasoftnanus.automation.core.ui.bootstrap.config;

import com.miasoftnanus.automation.core.utils.properties.PropertiesFileReader;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.BROWSER;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.BROWSER_LOGS;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.CHROME_DRIVER_VERSION;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.DOWNLOADS;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.ENVIRONMENT_NAME;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.EXPLICIT_TIME;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.HEIGHT;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.IMPLICIT_TIME;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.INCOGNITO_MODE;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.PAGE_LOAD_TIME;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.SELENIUM_HUB_PORT;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.SELENIUM_HUB_URL;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.SLEEP_TIME;
import static com.miasoftnanus.automation.core.ui.bootstrap.config.ReservedWords.WIDTH;

public class UiConfig {
    private static final String UI_PROP_FILE = "./gradle.properties";
    private static UiConfig instance;

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
        PropertiesFileReader propertiesFileReader = new PropertiesFileReader(UI_PROP_FILE);
        browserLogsEnabled = Boolean.parseBoolean(propertiesFileReader.getPropertyValue(BROWSER_LOGS.val()));
        environment = propertiesFileReader.getPropertyValue(ENVIRONMENT_NAME.val());
        implicitTime = Integer.parseInt(propertiesFileReader.getPropertyValue(IMPLICIT_TIME.val()));
        explicitTime = Integer.parseInt(propertiesFileReader.getPropertyValue(EXPLICIT_TIME.val()));
        sleepTime = Integer.parseInt(propertiesFileReader.getPropertyValue(SLEEP_TIME.val()));
        browser = propertiesFileReader.getPropertyValue(BROWSER.val());
        pageLoadTime = Long.parseLong(propertiesFileReader.getPropertyValue(PAGE_LOAD_TIME.val()));
        chromeDriverVersion = propertiesFileReader.getPropertyValue(CHROME_DRIVER_VERSION.val());
        downloadsFolder = propertiesFileReader.getPropertyValue(DOWNLOADS.val());
        widthOfBrowser = Integer.parseInt(propertiesFileReader.getPropertyValue(WIDTH.val()));
        heightOfBrowser = Integer.parseInt(propertiesFileReader.getPropertyValue(HEIGHT.val()));
        seleniumHubUrl = propertiesFileReader.getPropertyValue(SELENIUM_HUB_URL.val());
        seleniumHubPort = propertiesFileReader.getPropertyValue(SELENIUM_HUB_PORT.val());
        isIncognitoMode = Boolean.parseBoolean(propertiesFileReader.getPropertyValue(INCOGNITO_MODE.val()));
    }

    /**
     * Initializes the singleton UI Config instance.
     *
     * @return singleton instance.
     */
    public static synchronized UiConfig getInstance() {
        if (Objects.isNull(instance)) {
            instance = new UiConfig();
        }
        return instance;
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
