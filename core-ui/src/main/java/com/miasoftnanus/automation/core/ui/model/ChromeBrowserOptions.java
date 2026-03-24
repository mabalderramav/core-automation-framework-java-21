package com.miasoftnanus.automation.core.ui.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor
public enum ChromeBrowserOptions {
    DOWNLOAD_DEFAULT_DIRECTORY("download.default_directory"),
    BROWSER_ARGS_SIDE_NAVIGATION("--disable-browser-side-navigation"),
    PROFILE_DEFAULT_CONTENT_SETTINGS_POPUPS("profile.default_content_settings.popups"),
    PREFS("prefs"),
    DISABLE_BLINK_FEATURES_AUTOMATION_CONTROLLED("--disable-blink-features=AutomationControlled"),
    DISABLE_WEB_SECURITY("--disable-web-security"),
    EXCLUDE_SWITCHES("excludeSwitches"),
    USE_AUTOMATION_EXTENSION("useAutomationExtension"),
    ENABLE_AUTOMATION("enable-automation"),
    LOGGING_PREFS("goog:loggingPrefs"),
    REMOTE_ALLOW_ORIGINS("--remote-allow-origins=*"),
    INCOGNITO_MODE("--incognito");

    private final String val;
}
