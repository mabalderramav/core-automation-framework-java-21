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
class OpenBrowserServiceTest {

    @Mock
    private BrowserRepository browserRepository;

    @InjectMocks
    private OpenBrowserService openBrowserService;

    @Test
    void open_delegatesToRepositoryWithProvidedUrl() {
        String url = "https://example.com";

        assertThatCode(() -> openBrowserService.open(url))
                .doesNotThrowAnyException();

        verify(browserRepository).open(url);
        verifyNoMoreInteractions(browserRepository);
    }

    @Test
    void open_passesNullUrlToRepository() {
        assertThatCode(() -> openBrowserService.open(null))
                .doesNotThrowAnyException();

        verify(browserRepository).open(null);
        verifyNoMoreInteractions(browserRepository);
    }

    @Test
    void open_propagatesRepositoryException() {
        String url = "https://example.com";
        RuntimeException boom = new RuntimeException("boom");
        doThrow(boom).when(browserRepository).open(url);

        assertThatThrownBy(() -> openBrowserService.open(url))
                .isSameAs(boom);

        verify(browserRepository).open(url);
        verifyNoMoreInteractions(browserRepository);
    }
}

