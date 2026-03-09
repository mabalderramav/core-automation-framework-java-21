package com.miasoftnanus.automation.core.configuration.properties.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
public class UiConfig extends CommonConfig {
    private String browser;
    private int explicitTimeWait;
    private int implicitTimeWait;
    private int pageLoadTimeWait;
    private int sleepWaitTime;
    private String chromeDriverVersion;
    private int width;
    private int height;
    private String downloads;
    private boolean browserLogs;
    private String seleniumHubUrl;
    private int seleniumHubPort;
    private boolean incognitoMode;

    public UiConfig() {
        this.browser = "";
        this.explicitTimeWait = 0;
        this.implicitTimeWait = 0;
        this.pageLoadTimeWait = 0;
        this.sleepWaitTime = 0;
        this.chromeDriverVersion = "";
        this.width = 0;
        this.height = 0;
        this.downloads = "";
        this.browserLogs = false;
        this.seleniumHubUrl = "";
        this.seleniumHubPort = 0;
        this.incognitoMode = false;
    }
}
