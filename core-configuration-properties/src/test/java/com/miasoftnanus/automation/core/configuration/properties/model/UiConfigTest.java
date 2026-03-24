package com.miasoftnanus.automation.core.configuration.properties.model;

import com.miasoftnanus.automation.core.configuration.properties.bootstrap.UiConfigManager;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UiConfigTest {

    @Test
    void testUiConfigIfGetsByUiConfigManagerPart1() {
        // Act
        var uiConfig = UiConfigManager.getInstance().uiConfig();
        var environmentNameExpected = "QA";
        var environmentFilePathExpected = "";
        var implicitTimeWaitExpected = 15;
        var explicitTimeWaitExpected = 15;
        var sleepWaitTimeExpected = 1;
        var pageLoadTimeWaitExpected = 30;
        var widthExpected = 1920;
        var heightExpected = 1200;

        // Assertions
        assertThat(uiConfig.environmentName())
                .as("Environment name should be QA.")
                .isEqualTo(environmentNameExpected);
        assertThat(uiConfig.environmentFilePath())
                .as("Environment file path should be empty.")
                .isEqualTo(environmentFilePathExpected);
        assertThat(uiConfig.implicitTimeWait())
                .as("Implicit time wait should be 15 seconds.")
                .isEqualTo(implicitTimeWaitExpected);
        assertThat(uiConfig.explicitTimeWait())
                .as("Explicit time wait should be 15 seconds.")
                .isEqualTo(explicitTimeWaitExpected);
        assertThat(uiConfig.pageLoadTimeWait())
                .as("Page load time wait should be 30 seconds.")
                .isEqualTo(pageLoadTimeWaitExpected);
        assertThat(uiConfig.sleepWaitTime())
                .as("Sleep wait time should be 1 second.")
                .isEqualTo(sleepWaitTimeExpected);
        assertThat(uiConfig.width())
                .as("Width should be 1920 pixels.")
                .isEqualTo(widthExpected);
        assertThat(uiConfig.height())
                .as("Height should be 1080 pixels.")
                .isEqualTo(heightExpected);

    }

    @Test
    void testUiConfigIfGetsByUiConfigManagerPart2() {
        // Act
        var uiConfig = UiConfigManager.getInstance().uiConfig();
        var browserExpected = "CHROME";
        var seleniumHubUrlExpected = "http://localhost:4444/wd/hub";
        var seleniumHubPortExpected = 4444;
        var chromeDriverVersionExpected = "";
        var downloadsExpected = "src/test/resources/downloads/";
        var browserLogsExpected = false;
        var incognitoModeExpected = false;

        // Assertions
        assertThat(uiConfig.isBrowserLogsEnabled())
                .as("Browser logs should be disabled.")
                .isEqualTo(browserLogsExpected);
        assertThat(uiConfig.driverVersion())
                .as("Chrome driver version should be empty.")
                .isEqualTo(chromeDriverVersionExpected);
        assertThat(uiConfig.seleniumHubPort())
                .as("Selenium hub port should be 4444.")
                .isEqualTo(seleniumHubPortExpected);
        assertThat(uiConfig.seleniumHubUrl())
                .as("Selenium hub URL should be http://localhost:4444/wd/hub.")
                .isEqualTo(seleniumHubUrlExpected);
        assertThat(uiConfig.isIncognitoMode())
                .as("Incognito mode should be disabled.")
                .isEqualTo(incognitoModeExpected);
        assertThat(uiConfig.downloads())
                .as("Downloads folder should be src/test/resources/downloads/.")
                .isEqualTo(downloadsExpected);
        assertThat(uiConfig.browser())
                .as("Browser should be CHROME.")
                .isEqualTo(browserExpected);

    }
}
