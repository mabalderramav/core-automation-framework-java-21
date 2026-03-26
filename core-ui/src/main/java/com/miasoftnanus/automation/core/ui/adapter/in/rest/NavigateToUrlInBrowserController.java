package com.miasoftnanus.automation.core.ui.adapter.in.rest;

import com.miasoftnanus.automation.core.ui.application.port.in.NavigateToUrlInBrowserUseCase;
import lombok.RequiredArgsConstructor;

/**
 * Controller class responsible for handling operations related to navigating
 * to a specified URL within a web browser.
 * <p>
 * This class interacts with the NavigateToUrlInBrowserUseCase to delegate and
 * execute the URL navigation functionality. It acts as an entry point for triggering
 * the navigation process.
 * </p>
 */
@RequiredArgsConstructor
public class NavigateToUrlInBrowserController {
    private final NavigateToUrlInBrowserUseCase navigateToUrlInBrowserUseCase;

    /**
     * Navigates to the specified URL within a web browser.
     * This method delegates the navigation operation to the underlying use case.
     *
     * @param url the URL to navigate to; must be a valid and properly formatted string representing a web address.
     */
    public void navigateToUrl(String url) {
        navigateToUrlInBrowserUseCase.navigateTo(url);
    }
}
