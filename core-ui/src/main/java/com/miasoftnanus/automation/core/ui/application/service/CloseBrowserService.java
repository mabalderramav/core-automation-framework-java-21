package com.miasoftnanus.automation.core.ui.application.service;

import com.miasoftnanus.automation.core.ui.application.port.in.CloseBrowserUseCase;
import com.miasoftnanus.automation.core.ui.application.port.out.infrastructure.BrowserRepository;
import lombok.RequiredArgsConstructor;

/**
 * A service class responsible for closing the currently active web browser session.
 * This class implements the {@link CloseBrowserUseCase} interface and delegates the browser closing
 * operation to the {@link BrowserRepository}.
 */
@RequiredArgsConstructor
public class CloseBrowserService implements CloseBrowserUseCase {
    private final BrowserRepository browserRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() {
        browserRepository.close();
    }
}

