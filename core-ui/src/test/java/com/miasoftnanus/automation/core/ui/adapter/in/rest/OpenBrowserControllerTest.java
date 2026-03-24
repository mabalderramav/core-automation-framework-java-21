package com.miasoftnanus.automation.core.ui.adapter.in.rest;

import com.miasoftnanus.automation.core.ui.application.port.in.OpenBrowserUseCase;
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
class OpenBrowserControllerTest {

    @Mock
    private OpenBrowserUseCase openBrowserUseCase;

    @InjectMocks
    private OpenBrowserController controller;

    @Test
    void openBrowser_delegatesToUseCaseWithProvidedUrl() {
        String url = "https://example.com";

        assertThatCode(() -> controller.openBrowser(url))
                .doesNotThrowAnyException();

        verify(openBrowserUseCase).open(url);
        verifyNoMoreInteractions(openBrowserUseCase);
    }

    @Test
    void openBrowser_passesNullUrlToUseCase() {
        assertThatCode(() -> controller.openBrowser(null))
                .doesNotThrowAnyException();

        verify(openBrowserUseCase).open(null);
        verifyNoMoreInteractions(openBrowserUseCase);
    }

    @Test
    void openBrowser_propagatesUseCaseException() {
        String url = "https://example.com";
        RuntimeException boom = new RuntimeException("boom");
        doThrow(boom).when(openBrowserUseCase).open(url);

        assertThatThrownBy(() -> controller.openBrowser(url))
                .isSameAs(boom);

        verify(openBrowserUseCase).open(url);
        verifyNoMoreInteractions(openBrowserUseCase);
    }
}

