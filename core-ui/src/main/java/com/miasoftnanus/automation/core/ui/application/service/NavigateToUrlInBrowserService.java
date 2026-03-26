package com.miasoftnanus.automation.core.ui.application.service;

import com.miasoftnanus.automation.core.ui.application.port.in.NavigateToUrlInBrowserUseCase;
import com.miasoftnanus.automation.core.ui.application.port.out.infrastructure.BrowserRepository;
import lombok.RequiredArgsConstructor;

/**
 * A service class responsible for navigating to a specific URL within a web browser.
 * This class implements the {@link NavigateToUrlInBrowserUseCase} interface and delegates the URL navigation
 * operation to the {@link BrowserRepository}.
 */
@RequiredArgsConstructor
public class NavigateToUrlInBrowserService implements NavigateToUrlInBrowserUseCase {
    private final BrowserRepository browserRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public void navigateTo(String url) {
        browserRepository.navigateTo(url);
    }
}

