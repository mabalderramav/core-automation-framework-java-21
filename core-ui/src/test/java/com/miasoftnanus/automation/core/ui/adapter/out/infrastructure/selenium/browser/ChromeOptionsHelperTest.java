package com.miasoftnanus.automation.core.ui.adapter.out.infrastructure.selenium.browser;

import com.miasoftnanus.automation.core.configuration.properties.bootstrap.UiConfigManager;
import com.miasoftnanus.automation.core.configuration.properties.model.UiConfig;
import com.miasoftnanus.automation.core.ui.model.WebDriverTypes;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.openqa.selenium.logging.LogType;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.nio.file.Path;
import java.util.Map;
import java.util.logging.Level;

import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.DOWNLOAD_DEFAULT_DIRECTORY;
import static com.miasoftnanus.automation.core.ui.model.ChromeBrowserOptions.PROFILE_DEFAULT_CONTENT_SETTINGS_POPUPS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class ChromeOptionsHelperTest {

    @Test
    void getDownloadPath_returnsAbsolutePathForLocally() {
        String downloads = "src/test/resources/downloads/";

        try (MockedStatic<UiConfigManager> ignored = mockUiConfigManager(downloads, "LOCALLY")) {
            String actual = ChromeOptionsHelper.getDownloadPath(WebDriverTypes.LOCALLY);

            assertThat(actual).isEqualTo(Path.of(downloads).toAbsolutePath().toString());
        }
    }

    @Test
    void getDownloadPath_returnsConfiguredPathForDockerAndRemote() {
        String downloads = "/opt/selenium/downloads";

        try (MockedStatic<UiConfigManager> ignored = mockUiConfigManager(downloads, "DOCKER")) {
            assertThat(ChromeOptionsHelper.getDownloadPath(WebDriverTypes.DOCKER))
                    .isEqualTo(downloads);
            assertThat(ChromeOptionsHelper.getDownloadPath(WebDriverTypes.REMOTE))
                    .isEqualTo(downloads);
        }
    }

    @Test
    void getDownloadPath_returnsNullWhenTypeIsNull() {
        try (MockedStatic<UiConfigManager> ignored = mockUiConfigManager("downloads", "LOCALLY")) {
            assertThat(ChromeOptionsHelper.getDownloadPath(null)).isNull();
        }
    }

    @Test
    void getPrefsMap_returnsPopupAndDownloadDirectoryPreferences() {
        String downloads = "src/test/resources/downloads/";

        try (MockedStatic<UiConfigManager> ignored = mockUiConfigManager(downloads, "LOCALLY")) {
            Map<String, Object> actual = ChromeOptionsHelper.getPrefsMap();

            assertThat(actual)
                    .containsEntry(PROFILE_DEFAULT_CONTENT_SETTINGS_POPUPS.val(), 0)
                    .containsEntry(DOWNLOAD_DEFAULT_DIRECTORY.val(), Path.of(downloads).toAbsolutePath().toString());
        }
    }

    @Test
    void getPrefsMap_throwsWhenBrowserTypeDoesNotMatchWebDriverTypes() {
        try (MockedStatic<UiConfigManager> ignored = mockUiConfigManager("downloads", "CHROME")) {
            assertThatThrownBy(ChromeOptionsHelper::getPrefsMap)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("No enum constant")
                    .hasMessageContaining("CHROME");
        }
    }

    @Test
    void getLoggingPreferences_enablesPerformanceLogsAtAllLevel() {
        var loggingPreferences = ChromeOptionsHelper.getLoggingPreferences();

        assertThat(loggingPreferences.getEnabledLogTypes())
                .contains(LogType.PERFORMANCE);
        assertThat(loggingPreferences.getLevel(LogType.PERFORMANCE))
                .isEqualTo(Level.ALL);
    }

    @Test
    void constructor_isPrivateAndCanBeInvokedForCoverage() throws Exception {
        Constructor<ChromeOptionsHelper> constructor = ChromeOptionsHelper.class.getDeclaredConstructor();

        assertThat(Modifier.isPrivate(constructor.getModifiers())).isTrue();

        constructor.setAccessible(true);

        assertThatCode(constructor::newInstance)
                .doesNotThrowAnyException();
    }

    private MockedStatic<UiConfigManager> mockUiConfigManager(String downloads, String browser) {
        UiConfig uiConfig = mock(UiConfig.class);
        when(uiConfig.downloads()).thenReturn(downloads);
        when(uiConfig.browser()).thenReturn(browser);

        UiConfigManager uiConfigManager = mock(UiConfigManager.class);
        when(uiConfigManager.uiConfig()).thenReturn(uiConfig);

        MockedStatic<UiConfigManager> uiConfigManagerMock = mockStatic(UiConfigManager.class);
        uiConfigManagerMock.when(UiConfigManager::getInstance).thenReturn(uiConfigManager);
        return uiConfigManagerMock;
    }
}

