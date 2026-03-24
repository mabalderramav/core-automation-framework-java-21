package com.miasoftnanus.automation.core.ui.adapter.out.infrastructure.selenium.browser;

import com.miasoftnanus.automation.core.configuration.properties.bootstrap.UiConfigManager;
import com.miasoftnanus.automation.core.configuration.properties.model.UiConfig;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.nio.file.Path;
import java.util.Map;
import java.util.logging.Level;

import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.BROWSER_ARGS_SIDE_NAVIGATION;
import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.DISABLE_BLINK_FEATURES_AUTOMATION_CONTROLLED;
import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.DISABLE_WEB_SECURITY;
import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.DOWNLOAD_DEFAULT_DIRECTORY;
import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.ENABLE_AUTOMATION;
import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.EXCLUDE_SWITCHES;
import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.INCOGNITO_MODE;
import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.LOGGING_PREFS;
import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.PREFS;
import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.PROFILE_DEFAULT_CONTENT_SETTINGS_POPUPS;
import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.REMOTE_ALLOW_ORIGINS;
import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.USE_AUTOMATION_EXTENSION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class ChromeTest {

    @Test
    void constructor_addsLoggingAndIncognitoWhenBothFlagsAreEnabled() {
        String downloads = "src/test/resources/downloads/";

        try (MockedStatic<UiConfigManager> uiConfigManagerMock = mockUiConfigManager(downloads, true, true)) {
            TestChrome chrome = new TestChrome();
            ChromeOptions options = chrome.options();
            Map<String, Object> serializedOptions = options.asMap();

            uiConfigManagerMock.verify(UiConfigManager::getInstance, atLeastOnce());
            assertCommonOptions(options, serializedOptions, downloads);
            assertThat(serializedOptions.toString()).contains(INCOGNITO_MODE.val());

            Object loggingCapability = options.getCapability(LOGGING_PREFS.val());
            assertThat(loggingCapability).isInstanceOf(LoggingPreferences.class);

            LoggingPreferences loggingPreferences = (LoggingPreferences) loggingCapability;
            assertThat(loggingPreferences.getEnabledLogTypes()).contains(LogType.PERFORMANCE);
            assertThat(loggingPreferences.getLevel(LogType.PERFORMANCE)).isEqualTo(Level.ALL);
        }
    }

    @Test
    void constructor_skipsLoggingAndIncognitoWhenBothFlagsAreDisabled() {
        String downloads = "src/test/resources/downloads/";

        try (MockedStatic<UiConfigManager> uiConfigManagerMock = mockUiConfigManager(downloads, false, false)) {
            TestChrome chrome = new TestChrome();
            ChromeOptions options = chrome.options();
            Map<String, Object> serializedOptions = options.asMap();

            uiConfigManagerMock.verify(UiConfigManager::getInstance, atLeastOnce());
            assertCommonOptions(options, serializedOptions, downloads);
            assertThat(serializedOptions.toString()).doesNotContain(INCOGNITO_MODE.val());
            assertThat(options.getCapability(LOGGING_PREFS.val())).isNull();
        }
    }

    private void assertCommonOptions(ChromeOptions options, Map<String, Object> serializedOptions, String downloads) {
        assertThat(options).isNotNull();
        assertThat(options.getCapability(CapabilityType.ACCEPT_INSECURE_CERTS)).isEqualTo(true);
        assertThat(options.getCapability(ChromeOptions.CAPABILITY)).isNotNull();

        assertThat(serializedOptions)
                .containsEntry(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        assertThat(serializedOptions.toString())
                .contains(BROWSER_ARGS_SIDE_NAVIGATION.val())
                .contains(DISABLE_BLINK_FEATURES_AUTOMATION_CONTROLLED.val())
                .contains(REMOTE_ALLOW_ORIGINS.val())
                .contains(DISABLE_WEB_SECURITY.val())
                .contains(PREFS.val())
                .contains(PROFILE_DEFAULT_CONTENT_SETTINGS_POPUPS.val())
                .contains(DOWNLOAD_DEFAULT_DIRECTORY.val())
                .contains(Path.of(downloads).toAbsolutePath().toString())
                .contains(EXCLUDE_SWITCHES.val())
                .contains(ENABLE_AUTOMATION.val())
                .contains(USE_AUTOMATION_EXTENSION.val())
                .contains("false");
    }

    private MockedStatic<UiConfigManager> mockUiConfigManager(String downloads,
                                                              boolean browserLogsEnabled,
                                                              boolean incognitoMode) {
        UiConfig uiConfig = mock(UiConfig.class);
        when(uiConfig.browser()).thenReturn("LOCALLY");
        when(uiConfig.downloads()).thenReturn(downloads);
        when(uiConfig.isBrowserLogsEnabled()).thenReturn(browserLogsEnabled);
        when(uiConfig.isIncognitoMode()).thenReturn(incognitoMode);

        UiConfigManager uiConfigManager = mock(UiConfigManager.class);
        when(uiConfigManager.uiConfig()).thenReturn(uiConfig);

        MockedStatic<UiConfigManager> uiConfigManagerMock = mockStatic(UiConfigManager.class);
        uiConfigManagerMock.when(UiConfigManager::getInstance).thenReturn(uiConfigManager);
        return uiConfigManagerMock;
    }

    private static final class TestChrome extends Chrome {
    }
}

