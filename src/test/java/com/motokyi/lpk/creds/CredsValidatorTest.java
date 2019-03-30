package com.motokyi.lpk.creds;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CredsValidatorTest {


    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n", "1234567", "text"})
    void isValidUrlFalse(String value) {
        assertFalse(CredsValidator.isValid(CredsType.PASSWORD, value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"http://web.com", "https://web.com"})
    void isValidUrl(String value) {
        assertTrue(CredsValidator.isValid(CredsType.PASSWORD, value));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void isValidNameFalse(String value) {
        assertFalse(CredsValidator.isValid(CredsType.NAME, value));
    }

    @Test
    void isValidName() {
        assertTrue(CredsValidator.isValid(CredsType.NAME, "Some name"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void isValidLoginFalse(String value) {
        assertFalse(CredsValidator.isValid(CredsType.LOGIN, value));
    }

    @Test
    void isValidLogin() {
        assertTrue(CredsValidator.isValid(CredsType.LOGIN, "login"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n", "1234567"})
    void isValidPasswordFalse(String value) {
        assertFalse(CredsValidator.isValid(CredsType.PASSWORD, value));
    }

    @Test
    void isValidPassword() {
        assertTrue(CredsValidator.isValid(CredsType.PASSWORD, "password"));
    }
}