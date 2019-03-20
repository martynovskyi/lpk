package com.motokyi.lpk.ui.util;

import com.motokyi.lpk.ui.utils.UIUtils;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class UIUtilsTest {

    @Test
    void disabledTextField() {
        final String fieldName = "TextField";
        final JTextField result = UIUtils.disabledTextField(fieldName);

        assertAll(() -> {
            assertNotNull(result);
            assertFalse(result.isEditable());
            assertEquals(fieldName, result.getText());
        });
    }
}