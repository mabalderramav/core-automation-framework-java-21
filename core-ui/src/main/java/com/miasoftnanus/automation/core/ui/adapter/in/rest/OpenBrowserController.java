package com.miasoftnanus.automation.core.ui.adapter.in.rest;

import com.miasoftnanus.automation.core.ui.application.port.in.OpenBrowserUseCase;
import lombok.RequiredArgsConstructor;

/**
 * Controller class responsible for handling operations related to opening a web browser.
 * <p>
 * This class interacts with the {@link OpenBrowserUseCase} to perform the operation
 * of opening a browser and navigating to a specified URL. It serves as an entry point
 * to execute the open browser functionality.
 * </p>
 */
@RequiredArgsConstructor
public class OpenBrowserController {
    private final OpenBrowserUseCase openBrowserUseCase;

    /**
     * Opens a web browser and navigates to a specified URL.
     * This method delegates the operation to the underlying {@link OpenBrowserUseCase}.
     *
     * @param url the URL to navigate to; must be a valid and properly formatted string representing a web address.
     */
    public void openBrowser(String url) {
        openBrowserUseCase.open(url);
    }
}
