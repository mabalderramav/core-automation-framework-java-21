package com.miasoftnanus.automation.core.ui.config;


import com.miasoftnanus.automation.core.utils.properties.PropertiesFileReader;

import java.util.Objects;

public final class UiConfig {
    private static final String UI_PROP_FILE = "./gradle.properties";
    private static UiConfig instance;

    private final PropertiesFileReader propertiesFileReader;

    /**
     * Initializes an instance of {@link UiConfig}.
     */
    private UiConfig() {
        propertiesFileReader = new PropertiesFileReader(UI_PROP_FILE);
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
     * Gets the test execution environment name.
     *
     * @return execution environment name.
     */
    public String getEnvironment() {
        return propertiesFileReader.getPropertyValue(UiConfigWords.ENVIRONMENT_NAME.val());
    }

    /**
     * Gets the current Browser name.
     *
     * @return Browser value.
     */
    public String getBrowser() {
        return propertiesFileReader.getPropertyValue(UiConfigWords.BROWSER.val());
    }

    /**
     * Gets the implicit time wait for web driver default configuration.
     *
     * @return implicit time wait value.
     */
    public int getImplicitTime() {
        return Integer.parseInt(propertiesFileReader.getPropertyValue(UiConfigWords.IMPLICIT_TIME_WAIT.val()));
    }

    /**
     * Gets the explicit time wait for web driver default configuration.
     *
     * @return explicit time wait value.
     */
    public int getExplicitTime() {
        return Integer.parseInt(propertiesFileReader.getPropertyValue(UiConfigWords.EXPLICIT_TIME_WAIT.val()));
    }

    /**
     * Gets the sleep time wait for web driver default configuration.
     *
     * @return sleep time wait value.
     */
    public int getSleepTime() {
        return Integer.parseInt(propertiesFileReader.getPropertyValue(UiConfigWords.SLEEP_WAIT_TIME.val()));
    }

    /**
     * Gets the page load time wait for WebDriver default configuration.
     *
     * @return page load time wait value.
     */
    public long getPageLoadTime() {
        return Long.parseLong(propertiesFileReader.getPropertyValue(UiConfigWords.PAGE_LOAD_TIME_WAIT.val()));
    }

    /**
     * Gets the chrome driver version.
     *
     * @return chrome driver version.
     */
    public String getChromeDriverVersion() {
        return propertiesFileReader.getPropertyValue(UiConfigWords.CHROME_DRIVER_VERSION.val());
    }

    /**
     * Gets width of browser.
     *
     * @return width of browser.
     */
    public int getWidthOfBrowser() {
        return Integer.parseInt(propertiesFileReader.getPropertyValue(UiConfigWords.WIDTH.val()));
    }

    /**
     * Gets height of browser.
     *
     * @return height of browser.
     */
    public int getHeightOfBrowser() {
        return Integer.parseInt(propertiesFileReader.getPropertyValue(UiConfigWords.HEIGHT.val()));
    }

    /**
     * Gets Headless mode.
     *
     * @return Headless mode.
     */
    public boolean isHeadlessMode() {
        return Boolean.parseBoolean(propertiesFileReader.getPropertyValue(UiConfigWords.HEADLESS_MODE.val()));
    }
}
