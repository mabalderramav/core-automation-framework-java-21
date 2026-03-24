package com.miasoftnanus.automation.core.ui.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChromeBrowserOptionsTest {

    @Test
    void values_containsExpectedChromeBrowserOptionsInOrder() {
        assertThat(ChromeBrowserOptions.values())
                .containsExactly(
                        ChromeBrowserOptions.DOWNLOAD_DEFAULT_DIRECTORY,
                        ChromeBrowserOptions.BROWSER_ARGS_SIDE_NAVIGATION,
                        ChromeBrowserOptions.PROFILE_DEFAULT_CONTENT_SETTINGS_POPUPS,
                        ChromeBrowserOptions.PREFS,
                        ChromeBrowserOptions.DISABLE_BLINK_FEATURES_AUTOMATION_CONTROLLED,
                        ChromeBrowserOptions.DISABLE_WEB_SECURITY,
                        ChromeBrowserOptions.EXCLUDE_SWITCHES,
                        ChromeBrowserOptions.USE_AUTOMATION_EXTENSION,
                        ChromeBrowserOptions.ENABLE_AUTOMATION,
                        ChromeBrowserOptions.LOGGING_PREFS,
                        ChromeBrowserOptions.REMOTE_ALLOW_ORIGINS,
                        ChromeBrowserOptions.INCOGNITO_MODE
                );
    }

    @Test
    void downloadDefaultDirectory_returnsExpectedValue() {
        assertThat(ChromeBrowserOptions.DOWNLOAD_DEFAULT_DIRECTORY.val())
                .isEqualTo("download.default_directory");
    }

    @Test
    void browserArgsSideNavigation_returnsExpectedValue() {
        assertThat(ChromeBrowserOptions.BROWSER_ARGS_SIDE_NAVIGATION.val())
                .isEqualTo("--disable-browser-side-navigation");
    }

    @Test
    void profileDefaultContentSettingsPopups_returnsExpectedValue() {
        assertThat(ChromeBrowserOptions.PROFILE_DEFAULT_CONTENT_SETTINGS_POPUPS.val())
                .isEqualTo("profile.default_content_settings.popups");
    }

    @Test
    void prefs_returnsExpectedValue() {
        assertThat(ChromeBrowserOptions.PREFS.val()).isEqualTo("prefs");
    }

    @Test
    void disableBlinkFeaturesAutomationControlled_returnsExpectedValue() {
        assertThat(ChromeBrowserOptions.DISABLE_BLINK_FEATURES_AUTOMATION_CONTROLLED.val())
                .isEqualTo("--disable-blink-features=AutomationControlled");
    }

    @Test
    void disableWebSecurity_returnsExpectedValue() {
        assertThat(ChromeBrowserOptions.DISABLE_WEB_SECURITY.val())
                .isEqualTo("--disable-web-security");
    }

    @Test
    void excludeSwitches_returnsExpectedValue() {
        assertThat(ChromeBrowserOptions.EXCLUDE_SWITCHES.val())
                .isEqualTo("excludeSwitches");
    }

    @Test
    void useAutomationExtension_returnsExpectedValue() {
        assertThat(ChromeBrowserOptions.USE_AUTOMATION_EXTENSION.val())
                .isEqualTo("useAutomationExtension");
    }

    @Test
    void enableAutomation_returnsExpectedValue() {
        assertThat(ChromeBrowserOptions.ENABLE_AUTOMATION.val())
                .isEqualTo("enable-automation");
    }

    @Test
    void loggingPrefs_returnsExpectedValue() {
        assertThat(ChromeBrowserOptions.LOGGING_PREFS.val())
                .isEqualTo("goog:loggingPrefs");
    }

    @Test
    void remoteAllowOrigins_returnsExpectedValue() {
        assertThat(ChromeBrowserOptions.REMOTE_ALLOW_ORIGINS.val())
                .isEqualTo("--remote-allow-origins=*");
    }

    @Test
    void incognitoMode_returnsExpectedValue() {
        assertThat(ChromeBrowserOptions.INCOGNITO_MODE.val())
                .isEqualTo("--incognito");
    }
}

