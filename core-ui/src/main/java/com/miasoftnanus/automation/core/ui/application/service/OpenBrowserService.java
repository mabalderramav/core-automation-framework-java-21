package com.miasoftnanus.automation.core.ui.application.service;

import com.miasoftnanus.automation.core.ui.application.port.in.OpenBrowserUseCase;
import com.miasoftnanus.automation.core.ui.application.port.out.infrastructure.BrowserRepository;
import lombok.RequiredArgsConstructor;

/**
 * A service class responsible for opening a web browser and navigating to a specified URL.
 * This class implements the {@link OpenBrowserUseCase} interface and delegates the browser opening
 * operation to the {@link BrowserRepository}.
 */
@RequiredArgsConstructor
public class OpenBrowserService implements OpenBrowserUseCase {
    private final BrowserRepository browserRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public void open(String url) {
        browserRepository.open(url);
    }
}
