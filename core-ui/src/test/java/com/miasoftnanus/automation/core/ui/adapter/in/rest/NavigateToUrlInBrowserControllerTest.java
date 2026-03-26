package com.miasoftnanus.automation.core.ui.adapter.in.rest;

import com.miasoftnanus.automation.core.ui.application.port.in.NavigateToUrlInBrowserUseCase;
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
class NavigateToUrlInBrowserControllerTest {

    @Mock
    private NavigateToUrlInBrowserUseCase navigateToUrlInBrowserUseCase;

    @InjectMocks
    private NavigateToUrlInBrowserController controller;

    @Test
    void navigateToUrl_delegatesToUseCaseWithProvidedUrl() {
        String url = "https://example.com";

        assertThatCode(() -> controller.navigateToUrl(url))
                .doesNotThrowAnyException();

        verify(navigateToUrlInBrowserUseCase).navigateTo(url);
        verifyNoMoreInteractions(navigateToUrlInBrowserUseCase);
    }

    @Test
    void navigateToUrl_passesNullUrlToUseCase() {
        assertThatCode(() -> controller.navigateToUrl(null))
                .doesNotThrowAnyException();

        verify(navigateToUrlInBrowserUseCase).navigateTo(null);
        verifyNoMoreInteractions(navigateToUrlInBrowserUseCase);
    }

    @Test
    void navigateToUrl_propagatesUseCaseException() {
        String url = "https://example.com";
        RuntimeException boom = new RuntimeException("boom");
        doThrow(boom).when(navigateToUrlInBrowserUseCase).navigateTo(url);

        assertThatThrownBy(() -> controller.navigateToUrl(url))
                .isSameAs(boom);

        verify(navigateToUrlInBrowserUseCase).navigateTo(url);
        verifyNoMoreInteractions(navigateToUrlInBrowserUseCase);
    }
}
