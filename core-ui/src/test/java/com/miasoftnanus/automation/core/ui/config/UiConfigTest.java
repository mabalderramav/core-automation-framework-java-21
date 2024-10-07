package com.miasoftnanus.automation.core.ui.config;

import com.miasoftnanus.automation.core.utils.commons.ReservedWords;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UiConfigTest {
    private UiConfig uiConfig;

    @BeforeEach
    void setUp() {
        uiConfig = UiConfig.getInstance();
    }

    @Test
    void getInstance() {
        Assertions.assertNotNull(uiConfig);
    }

    @Test
    void getEnvironment() {
        Assertions.assertAll(() -> {
            Assertions.assertNotNull(uiConfig.getEnvironment());
            Assertions.assertEquals("QA", uiConfig.getEnvironment());
        });
    }

    @Test
    void getBrowser() {
        Assertions.assertAll(() -> {
            Assertions.assertNotNull(uiConfig.getBrowser());
            Assertions.assertEquals("CHROME", uiConfig.getBrowser());
        });
    }

    @Test
    void getImplicitTime() {
        Assertions.assertEquals(15, uiConfig.getImplicitTime());
    }

    @Test
    void getExplicitTime() {
        Assertions.assertEquals(15, uiConfig.getExplicitTime());
    }

    @Test
    void getSleepTime() {
        Assertions.assertEquals(2, uiConfig.getSleepTime());
    }

    @Test
    void getPageLoadTime() {
        Assertions.assertEquals(30, uiConfig.getPageLoadTime());
    }

    @Test
    void getChromeDriverVersion() {
        Assertions.assertAll(() -> {
            Assertions.assertNotNull(uiConfig.getChromeDriverVersion());
            Assertions.assertEquals(ReservedWords.STRING_EMPTY.val(), uiConfig.getChromeDriverVersion());
        });
    }

    @Test
    void getWidthOfBrowser() {
        Assertions.assertEquals(1920, uiConfig.getWidthOfBrowser());
    }

    @Test
    void getHeightOfBrowser() {
        Assertions.assertEquals(1200, uiConfig.getHeightOfBrowser());
    }

    @Test
    void isHeadlessMode() {
        Assertions.assertFalse(uiConfig.isHeadlessMode());
    }
}