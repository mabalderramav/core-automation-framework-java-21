package com.miasoftnanus.automation.core.ui.adapter.out.infrastructure.selenium.browser;

import com.miasoftnanus.automation.core.configuration.properties.bootstrap.UiConfigManager;
import com.miasoftnanus.automation.core.configuration.properties.model.UiConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Answers.RETURNS_SELF;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class ChromeLocallyTest {

    @Test
    void getDriver_usesConfiguredDriverVersionWhenPresent() {
        String driverVersion = "136.0.7103.113";
        WebDriver expectedDriver = mock(WebDriver.class);
        WebDriverManager webDriverManager = mock(WebDriverManager.class, RETURNS_SELF);
        when(webDriverManager.create()).thenReturn(expectedDriver);

        try (MockedStatic<UiConfigManager> uiConfigManagerMock = mockUiConfigManager(driverVersion);
             MockedStatic<WebDriverManager> webDriverManagerMock = mockStatic(WebDriverManager.class)) {
            webDriverManagerMock.when(WebDriverManager::chromedriver).thenReturn(webDriverManager);

            ChromeLocally chromeLocally = new ChromeLocally();
            WebDriver actualDriver = chromeLocally.getDriver();

            assertThat(actualDriver).isSameAs(expectedDriver);
            assertThat(chromeLocally.options()).isNotNull();
            uiConfigManagerMock.verify(UiConfigManager::getInstance, atLeastOnce());
            webDriverManagerMock.verify(WebDriverManager::chromedriver);
            verify(webDriverManager).driverVersion(driverVersion);
            verify(webDriverManager).capabilities(chromeLocally.options());
            verify(webDriverManager).create();
            verifyNoMoreInteractions(webDriverManager);
        }
    }

    @Test
    void getDriver_skipsDriverVersionWhenItIsNull() {
        WebDriver expectedDriver = mock(WebDriver.class);
        WebDriverManager webDriverManager = mock(WebDriverManager.class, RETURNS_SELF);
        when(webDriverManager.create()).thenReturn(expectedDriver);

        try (MockedStatic<UiConfigManager> uiConfigManagerMock = mockUiConfigManager(null);
             MockedStatic<WebDriverManager> webDriverManagerMock = mockStatic(WebDriverManager.class)) {
            webDriverManagerMock.when(WebDriverManager::chromedriver).thenReturn(webDriverManager);

            ChromeLocally chromeLocally = new ChromeLocally();
            WebDriver actualDriver = chromeLocally.getDriver();

            assertThat(actualDriver).isSameAs(expectedDriver);
            uiConfigManagerMock.verify(UiConfigManager::getInstance, atLeastOnce());
            webDriverManagerMock.verify(WebDriverManager::chromedriver);
            verify(webDriverManager, never()).driverVersion(org.mockito.ArgumentMatchers.anyString());
            verify(webDriverManager).capabilities(chromeLocally.options());
            verify(webDriverManager).create();
            verifyNoMoreInteractions(webDriverManager);
        }
    }

    @Test
    void getDriver_skipsDriverVersionWhenItIsEmpty() {
        WebDriver expectedDriver = mock(WebDriver.class);
        WebDriverManager webDriverManager = mock(WebDriverManager.class, RETURNS_SELF);
        when(webDriverManager.create()).thenReturn(expectedDriver);

        try (MockedStatic<UiConfigManager> uiConfigManagerMock = mockUiConfigManager("");
             MockedStatic<WebDriverManager> webDriverManagerMock = mockStatic(WebDriverManager.class)) {
            webDriverManagerMock.when(WebDriverManager::chromedriver).thenReturn(webDriverManager);

            ChromeLocally chromeLocally = new ChromeLocally();
            WebDriver actualDriver = chromeLocally.getDriver();

            assertThat(actualDriver).isSameAs(expectedDriver);
            uiConfigManagerMock.verify(UiConfigManager::getInstance, atLeastOnce());
            webDriverManagerMock.verify(WebDriverManager::chromedriver);
            verify(webDriverManager, never()).driverVersion(org.mockito.ArgumentMatchers.anyString());
            verify(webDriverManager).capabilities(chromeLocally.options());
            verify(webDriverManager).create();
            verifyNoMoreInteractions(webDriverManager);
        }
    }

    private MockedStatic<UiConfigManager> mockUiConfigManager(String driverVersion) {
        UiConfig uiConfig = mock(UiConfig.class);
        when(uiConfig.browser()).thenReturn("LOCALLY");
        when(uiConfig.downloads()).thenReturn("src/test/resources/downloads/");
        when(uiConfig.isBrowserLogsEnabled()).thenReturn(false);
        when(uiConfig.isIncognitoMode()).thenReturn(false);
        when(uiConfig.driverVersion()).thenReturn(driverVersion);

        UiConfigManager uiConfigManager = mock(UiConfigManager.class);
        when(uiConfigManager.uiConfig()).thenReturn(uiConfig);

        MockedStatic<UiConfigManager> uiConfigManagerMock = mockStatic(UiConfigManager.class);
        uiConfigManagerMock.when(UiConfigManager::getInstance).thenReturn(uiConfigManager);
        return uiConfigManagerMock;
    }
}

