package com.motokyi.lpk.ui.util;

import com.motokyi.lpk.ui.utils.UIUtils;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static com.motokyi.lpk.ui.utils.Icons.COPY;
import static org.junit.jupiter.api.Assertions.*;

class UIUtilsTest {

    @Test
    void disabledTextField() {
        final String fieldName = "TextField";
        final JTextField result = UIUtils.Components.disabledTextField(fieldName);

        assertAll(() -> {
            assertNotNull(result);
            assertFalse(result.isEditable());
            assertEquals(fieldName, result.getText());
        });
    }

    @Test
    void copyButton() {
        final JButton result = UIUtils.Components.copyButton();

        assertAll(() -> {
            assertNotNull(result);
            assertEquals(COPY, result.getIcon());
        });

    }

    @Test
    void wrap() {
        final JPanel result = UIUtils.Components.wrap(new JPanel(), new JButton("button"), new JTextField("text"));
        assertAll(() -> {
            assertNotNull(result);
            assertTrue(result.getLayout() instanceof FlowLayout);
            assertEquals(3, result.getComponentCount());
        });
    }

    @Test
    void wrapBox() {
        final JPanel result = UIUtils.Components.wrapBox(new JPanel(), new JButton("button"), new JLabel("text"));
        assertAll(() -> {
            assertNotNull(result);
            assertTrue(result.getLayout() instanceof BoxLayout);
            assertEquals(3, result.getComponentCount());
        });

    }
}