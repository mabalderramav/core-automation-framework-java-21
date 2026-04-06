package com.miasoftnanus.automation.core.ui.application.service;

import com.miasoftnanus.automation.core.ui.application.port.in.CloseBrowserUseCase;
import com.miasoftnanus.automation.core.ui.application.port.out.infrastructure.BrowserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class CloseBrowserServiceTest {

    @Mock
    private BrowserRepository browserRepository;

    @InjectMocks
    private CloseBrowserService closeBrowserService;

    @Test
    void closeBrowserService_implementsCloseBrowserUseCase() {
        assertThat(closeBrowserService).isInstanceOf(CloseBrowserUseCase.class);
    }

    @Test
    void close_delegatesToRepository() {
        assertThatCode(() -> closeBrowserService.close())
                .doesNotThrowAnyException();

        verify(browserRepository).close();
        verifyNoMoreInteractions(browserRepository);
    }

    @Test
    void close_invokesRepositoryCloseExactlyOnce() {
        closeBrowserService.close();

        verify(browserRepository).close();
        verifyNoMoreInteractions(browserRepository);
    }

    @Test
    void close_propagatesRepositoryRuntimeException() {
        RuntimeException cause = new RuntimeException("browser session already closed");
        doThrow(cause).when(browserRepository).close();

        assertThatThrownBy(() -> closeBrowserService.close())
                .isInstanceOf(RuntimeException.class)
                .isSameAs(cause)
                .hasMessage("browser session already closed");

        verify(browserRepository).close();
        verifyNoMoreInteractions(browserRepository);
    }

    @Test
    void close_propagatesArbitraryRuntimeException() {
        IllegalStateException cause = new IllegalStateException("driver not initialised");
        doThrow(cause).when(browserRepository).close();

        assertThatThrownBy(() -> closeBrowserService.close())
                .isInstanceOf(IllegalStateException.class)
                .isSameAs(cause);

        verify(browserRepository).close();
        verifyNoMoreInteractions(browserRepository);
    }
}

