package com.miasoftnanus.automation.core.ui.adapter.out.infrastructure.selenium.browser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SeleniumChromeRepositoryTest {

    @Mock
    private Browser browser;

    @Mock
    private WebDriver webDriver;

    @InjectMocks
    private SeleniumChromeRepository repository;

    @Test
    void open_delegatesToBrowserDriverWithProvidedUrl() {
        String url = "https://example.com/login";
        when(browser.getDriver()).thenReturn(webDriver);

        repository.open(url);

        verify(browser).getDriver();
        verify(webDriver).get(url);
        verifyNoMoreInteractions(browser, webDriver);
    }

    @Test
    void open_passesNullUrlWithoutChangingIt() {
        when(browser.getDriver()).thenReturn(webDriver);

        repository.open(null);

        verify(browser).getDriver();
        verify(webDriver).get(null);
        verifyNoMoreInteractions(browser, webDriver);
    }

    @Test
    void open_propagatesExceptionFromBrowserGetDriver() {
        RuntimeException boom = new RuntimeException("boom");
        when(browser.getDriver()).thenThrow(boom);

        assertThatThrownBy(() -> repository.open("https://example.com"))
                .isSameAs(boom);

        verify(browser).getDriver();
        verifyNoMoreInteractions(browser, webDriver);
    }

    @Test
    void open_propagatesExceptionFromDriverGet() {
        RuntimeException boom = new RuntimeException("navigation failed");
        String url = "https://example.com";
        when(browser.getDriver()).thenReturn(webDriver);
        org.mockito.Mockito.doThrow(boom).when(webDriver).get(url);

        assertThatThrownBy(() -> repository.open(url))
                .isSameAs(boom);

        verify(browser).getDriver();
        verify(webDriver).get(url);
        verifyNoMoreInteractions(browser, webDriver);
    }
}

