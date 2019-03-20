package com.motokyi.lpk.ui.utils;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class JTextFieldFactoryTest {

    @Test
    void disabledTextField() {
        final String fieldText = "TextField";
        final JTextField result = JTextFieldFactory.disabledTextField(fieldText);

        assertAll(() -> {
            assertNotNull(result);
            assertFalse(result.isEditable());
            assertEquals(fieldText, result.getText());
        });
    }

    @Test
    void disabledTextFieldWithName() {
        final String fieldName = "TextField";
        final String fieldText = "Text";
        final JTextField result = JTextFieldFactory.disabledTextField(fieldName, fieldText);

        assertAll(() -> {
            assertNotNull(result);
            assertFalse(result.isEditable());
            assertEquals(fieldText, result.getText());
            assertEquals(fieldName, result.getName());
        });
    }
}