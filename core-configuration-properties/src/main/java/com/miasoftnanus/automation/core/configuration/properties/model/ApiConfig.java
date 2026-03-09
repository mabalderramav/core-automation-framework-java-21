package com.miasoftnanus.automation.core.configuration.properties.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
public class ApiConfig extends CommonConfig {
    private String apiName;
    private String versionName;
    private String authenticationType;
    private String authenticationUserType;

    public ApiConfig() {
        super();
        this.apiName = "";
        this.versionName = "";
        this.authenticationType = "";
        this.authenticationUserType = "";
    }
}
