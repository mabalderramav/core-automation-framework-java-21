package com.miasoftnanus.automation.core.ui.config;

import com.miasoftnanus.automation.core.utils.commons.ReservedWords;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class UiConfigWordsTest {

    @ParameterizedTest
    @EnumSource(UiConfigWords.class)
    void testUiConfigWords(UiConfigWords uiConfigWords) {
        var actual = uiConfigWords.val().toLowerCase();
        var expected = uiConfigWords.name().toLowerCase()
                .replace(ReservedWords.STRING_UNDERSCORE.val(), ReservedWords.STRING_EMPTY.val());
        var errorMessage = "The value should be the same as the enum name";
        Assertions.assertEquals(expected, actual, errorMessage);
    }

    @ParameterizedTest
    @EnumSource(UiConfigWords.class)
    void testVal(UiConfigWords uiConfigWords) {
        var actual = uiConfigWords.val();
        var errorMessage = "The value should not be null";
        Assertions.assertNotNull(actual, errorMessage);
    }
}