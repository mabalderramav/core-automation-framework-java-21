package com.miasoftnanus.automation.core.ui.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BrowserTypesTest {

    @Test
    void values_containsExpectedBrowserTypesInOrder() {
        assertThat(BrowserTypes.values())
                .containsExactly(
                        BrowserTypes.CHROME,
                        BrowserTypes.FIREFOX,
                        BrowserTypes.EDGE,
                        BrowserTypes.SAFARI
                );
    }

    @Test
    void chrome_returnsExpectedDisplayValue() {
        assertThat(BrowserTypes.CHROME.val()).isEqualTo("Chrome");
    }

    @Test
    void firefox_returnsExpectedDisplayValue() {
        assertThat(BrowserTypes.FIREFOX.val()).isEqualTo("Firefox");
    }

    @Test
    void edge_returnsExpectedDisplayValue() {
        assertThat(BrowserTypes.EDGE.val()).isEqualTo("Edge");
    }

    @Test
    void safari_returnsExpectedDisplayValue() {
        assertThat(BrowserTypes.SAFARI.val()).isEqualTo("Safari");
    }
}

