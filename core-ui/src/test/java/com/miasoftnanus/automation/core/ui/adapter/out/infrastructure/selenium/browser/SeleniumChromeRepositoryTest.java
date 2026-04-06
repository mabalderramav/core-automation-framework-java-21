package com.miasoftnanus.automation.core.ui.adapter.out.infrastructure.selenium.browser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SeleniumChromeRepositoryTest {

    @Mock
    private Browser browser;

    @Mock
    private WebDriver webDriver;

    @Mock
    private WebDriver.Navigation navigation;

    @InjectMocks
    private SeleniumChromeRepository repository;

    @Test
    void open_delegatesToBrowserDriverWithProvidedUrl() {
        String url = "https://example.com/login";
        when(browser.getDriver()).thenReturn(webDriver);

        assertThatCode(() -> repository.open(url))
                .doesNotThrowAnyException();

        verify(browser).getDriver();
        verify(webDriver).get(url);
        verifyNoMoreInteractions(browser, webDriver, navigation);
    }

    @Test
    void open_passesNullUrlWithoutChangingIt() {
        when(browser.getDriver()).thenReturn(webDriver);

        assertThatCode(() -> repository.open(null))
                .doesNotThrowAnyException();

        verify(browser).getDriver();
        verify(webDriver).get(null);
        verifyNoMoreInteractions(browser, webDriver, navigation);
    }

    @Test
    void open_propagatesExceptionFromBrowserGetDriver() {
        RuntimeException boom = new RuntimeException("boom");
        when(browser.getDriver()).thenThrow(boom);

        assertThatThrownBy(() -> repository.open("https://example.com"))
                .isSameAs(boom);

        verify(browser).getDriver();
        verifyNoMoreInteractions(browser, webDriver, navigation);
    }

    @Test
    void open_propagatesExceptionFromDriverGet() {
        RuntimeException boom = new RuntimeException("navigation failed");
        String url = "https://example.com";
        when(browser.getDriver()).thenReturn(webDriver);
        doThrow(boom).when(webDriver).get(url);

        assertThatThrownBy(() -> repository.open(url))
                .isSameAs(boom);

        verify(browser).getDriver();
        verify(webDriver).get(url);
        verifyNoMoreInteractions(browser, webDriver, navigation);
    }

    @Test
    void navigateTo_delegatesToBrowserNavigationWithProvidedUrl() {
        String url = "https://example.com/dashboard";
        when(browser.getDriver()).thenReturn(webDriver);
        when(webDriver.navigate()).thenReturn(navigation);

        assertThatCode(() -> repository.navigateTo(url))
                .doesNotThrowAnyException();

        verify(browser).getDriver();
        verify(webDriver).navigate();
        verify(navigation).to(url);
        verifyNoMoreInteractions(browser, webDriver, navigation);
    }

    @Test
    void navigateTo_passesNullUrlWithoutChangingIt() {
        when(browser.getDriver()).thenReturn(webDriver);
        when(webDriver.navigate()).thenReturn(navigation);

        assertThatCode(() -> repository.navigateTo(null))
                .doesNotThrowAnyException();

        verify(browser).getDriver();
        verify(webDriver).navigate();
        verify(navigation).to((String) null);
        verifyNoMoreInteractions(browser, webDriver, navigation);
    }

    @Test
    void navigateTo_propagatesExceptionFromBrowserGetDriver() {
        RuntimeException boom = new RuntimeException("boom");
        when(browser.getDriver()).thenThrow(boom);

        assertThatThrownBy(() -> repository.navigateTo("https://example.com"))
                .isSameAs(boom);

        verify(browser).getDriver();
        verifyNoMoreInteractions(browser, webDriver, navigation);
    }

    @Test
    void navigateTo_propagatesExceptionFromDriverNavigate() {
        RuntimeException boom = new RuntimeException("cannot create navigation");
        when(browser.getDriver()).thenReturn(webDriver);
        when(webDriver.navigate()).thenThrow(boom);

        assertThatThrownBy(() -> repository.navigateTo("https://example.com"))
                .isSameAs(boom);

        verify(browser).getDriver();
        verify(webDriver).navigate();
        verifyNoMoreInteractions(browser, webDriver, navigation);
    }

    @Test
    void navigateTo_propagatesExceptionFromNavigationTo() {
        RuntimeException boom = new RuntimeException("navigation failed");
        String url = "https://example.com";
        when(browser.getDriver()).thenReturn(webDriver);
        when(webDriver.navigate()).thenReturn(navigation);
        doThrow(boom).when(navigation).to(url);

        assertThatThrownBy(() -> repository.navigateTo(url))
                .isSameAs(boom);

        verify(browser).getDriver();
        verify(webDriver).navigate();
        verify(navigation).to(url);
        verifyNoMoreInteractions(browser, webDriver, navigation);
    }

    // ── close ────────────────────────────────────────────────────────────────

    @Test
    void close_delegatesToBrowserDriverQuit() {
        when(browser.getDriver()).thenReturn(webDriver);

        assertThatCode(() -> repository.close())
                .doesNotThrowAnyException();

        verify(browser).getDriver();
        verify(webDriver).quit();
        verifyNoMoreInteractions(browser, webDriver, navigation);
    }

    @Test
    void close_propagatesExceptionFromBrowserGetDriver() {
        RuntimeException boom = new RuntimeException("driver not initialised");
        when(browser.getDriver()).thenThrow(boom);

        assertThatThrownBy(() -> repository.close())
                .isInstanceOf(RuntimeException.class)
                .isSameAs(boom)
                .hasMessage("driver not initialised");

        verify(browser).getDriver();
        verifyNoMoreInteractions(browser, webDriver, navigation);
    }

    @Test
    void close_propagatesExceptionFromDriverQuit() {
        RuntimeException boom = new RuntimeException("quit failed");
        when(browser.getDriver()).thenReturn(webDriver);
        doThrow(boom).when(webDriver).quit();

        assertThatThrownBy(() -> repository.close())
                .isInstanceOf(RuntimeException.class)
                .isSameAs(boom)
                .hasMessage("quit failed");

        verify(browser).getDriver();
        verify(webDriver).quit();
        verifyNoMoreInteractions(browser, webDriver, navigation);
    }
}