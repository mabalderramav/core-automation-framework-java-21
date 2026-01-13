package com.miasoftnanus.automation.core.environment.model;

/**
 * Custom reserved words enum.
 */
enum ReservedWords {
    EMPTY_STRING("");

    private final String word;

    /**
     * Initializes Reserved Words enum.
     *
     * @param word original word.
     */
    ReservedWords(final String word) {
        this.word = word;
    }

    /**
     * Gets the enum word value.
     *
     * @return original word.
     */
    public String val() {
        return word;
    }
}
