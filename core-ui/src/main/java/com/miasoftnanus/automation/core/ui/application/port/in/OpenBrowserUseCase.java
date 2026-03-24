package com.miasoftnanus.automation.core.ui.application.port.in;

/**
 * Represents a use case for opening a web browser and navigating to a specified URL.
 * This interface defines a single method for performing the browser operation.
 */
public interface OpenBrowserUseCase {

     /**
      * Opens a web browser and navigates to the specified URL.
      *
      * @param url the URL to navigate to must be a valid and properly formatted string representing a web address.
      */
     void open(String url);
}
