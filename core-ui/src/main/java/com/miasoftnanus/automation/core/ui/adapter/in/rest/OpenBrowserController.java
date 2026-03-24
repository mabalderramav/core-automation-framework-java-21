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

    public void openBrowser(String url) {
        openBrowserUseCase.open(url);
    }
}
