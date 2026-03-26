package com.miasoftnanus.automation.core.ui.application.service;

import com.miasoftnanus.automation.core.ui.application.port.out.infrastructure.BrowserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class NavigateToUrlInBrowserServiceTest {

    @Mock
    private BrowserRepository browserRepository;

    @InjectMocks
    private NavigateToUrlInBrowserService navigateToUrlInBrowserService;

    @Test
    void navigateTo_delegatesToRepositoryWithProvidedUrl() {
        String url = "https://example.com";

        assertThatCode(() -> navigateToUrlInBrowserService.navigateTo(url))
                .doesNotThrowAnyException();

        verify(browserRepository).navigateTo(url);
        verifyNoMoreInteractions(browserRepository);
    }

    @Test
    void navigateTo_passesNullUrlToRepository() {
        assertThatCode(() -> navigateToUrlInBrowserService.navigateTo(null))
                .doesNotThrowAnyException();

        verify(browserRepository).navigateTo(null);
        verifyNoMoreInteractions(browserRepository);
    }

    @Test
    void navigateTo_propagatesRepositoryException() {
        String url = "https://example.com";
        RuntimeException boom = new RuntimeException("boom");
        doThrow(boom).when(browserRepository).navigateTo(url);

        assertThatThrownBy(() -> navigateToUrlInBrowserService.navigateTo(url))
                .isSameAs(boom);

        verify(browserRepository).navigateTo(url);
        verifyNoMoreInteractions(browserRepository);
    }
}
