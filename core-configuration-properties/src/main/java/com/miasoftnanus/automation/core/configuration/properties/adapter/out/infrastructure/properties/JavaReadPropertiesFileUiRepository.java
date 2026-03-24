package com.miasoftnanus.automation.core.configuration.properties.adapter.out.infrastructure.properties;

import com.miasoftnanus.automation.core.configuration.properties.application.port.out.infrastructure.ReadPropertiesFileUiRepository;
import com.miasoftnanus.automation.core.configuration.properties.model.CommonConfigWords;
import com.miasoftnanus.automation.core.configuration.properties.model.UiConfig;
import com.miasoftnanus.automation.core.configuration.properties.model.UiConfigWords;
import com.miasoftnanus.automation.core.utils.properties.PropertiesFileReader;

/**
 * An implementation of the {@code ReadPropertiesFileUiRepository} interface for reading UI-related
 * properties from a specified properties file and mapping them to a {@code UiConfig} object. This
 * class acts as a concrete repository to encapsulate the property retrieval logic and configuration
 * conversion.
 */
public class JavaReadPropertiesFileUiRepository implements ReadPropertiesFileUiRepository {

    /**
     * {@inheritDoc}
     */
    @Override
    public UiConfig readPropertiesFile(String propertyFilePath) {
        var propertiesFileReader = new PropertiesFileReader(propertyFilePath);
        var uiConfig = new UiConfig();
        uiConfig.environmentName(propertiesFileReader.getPropertyValue(CommonConfigWords.ENVIRONMENT_NAME.val()));
        uiConfig.environmentFilePath(
                propertiesFileReader.getPropertyValue(CommonConfigWords.ENVIRONMENT_FILE_PATH.val()));
        uiConfig.browser(propertiesFileReader.getPropertyValue(UiConfigWords.UI_BROWSER.val()));
        uiConfig.isBrowserLogsEnabled(
                Boolean.parseBoolean(propertiesFileReader.getPropertyValue(UiConfigWords.UI_BROWSER_LOGS.val())));
        uiConfig.pageLoadTimeWait(
                Integer.parseInt(propertiesFileReader.getPropertyValue(UiConfigWords.UI_PAGE_LOAD_TIME.val())));
        uiConfig.sleepWaitTime(
                Integer.parseInt(propertiesFileReader.getPropertyValue(UiConfigWords.UI_SLEEP_WAIT_TIME.val())));
        uiConfig.driverVersion(
                propertiesFileReader.getPropertyValue(UiConfigWords.UI_DRIVER_VERSION.val()));
        uiConfig.width(
                Integer.parseInt(propertiesFileReader.getPropertyValue(UiConfigWords.UI_WIDTH.val())));
        uiConfig.height(
                Integer.parseInt(propertiesFileReader.getPropertyValue(UiConfigWords.UI_HEIGHT.val())));
        uiConfig.downloads(propertiesFileReader.getPropertyValue(UiConfigWords.UI_DOWNLOADS.val()));
        uiConfig.seleniumHubUrl(propertiesFileReader.getPropertyValue(UiConfigWords.UI_SELENIUM_HUB_URL.val()));
        uiConfig.seleniumHubPort(
                Integer.parseInt(propertiesFileReader.getPropertyValue(UiConfigWords.UI_SELENIUM_HUB_PORT.val())));
        uiConfig.isIncognitoMode(
                Boolean.parseBoolean(propertiesFileReader.getPropertyValue(UiConfigWords.UI_INCOGNITO_MODE.val())));
        uiConfig.explicitTimeWait(
                Integer.parseInt(propertiesFileReader.getPropertyValue(UiConfigWords.UI_EXPLICIT_TIME.val())));
        uiConfig.implicitTimeWait(
                Integer.parseInt(propertiesFileReader.getPropertyValue(UiConfigWords.UI_IMPLICIT_TIME.val())));
        return uiConfig;
    }
}
