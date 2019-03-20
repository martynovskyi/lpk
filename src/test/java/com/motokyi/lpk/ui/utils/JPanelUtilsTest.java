package com.motokyi.lpk.ui.utils;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class JPanelUtilsTest {

    @Test
    void wrap() {
        final JPanel result = JPanelUtils.wrap(new JPanel(), new JButton("button"), new JTextField("text"));
        assertAll(() -> {
            assertNotNull(result);
            assertTrue(result.getLayout() instanceof FlowLayout);
            assertEquals(3, result.getComponentCount());
        });
    }

    @Test
    void wrapBox() {
        final JPanel result = JPanelUtils.wrapBox(new JPanel(), new JButton("button"), new JLabel("text"));
        assertAll(() -> {
            assertNotNull(result);
            assertTrue(result.getLayout() instanceof BoxLayout);
            assertEquals(3, result.getComponentCount());
        });

    }
}