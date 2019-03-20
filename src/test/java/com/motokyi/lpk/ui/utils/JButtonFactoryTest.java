package com.motokyi.lpk.ui.utils;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static com.motokyi.lpk.ui.utils.Icons.COPY;
import static org.junit.jupiter.api.Assertions.*;

class JButtonFactoryTest {

    @Test
    void copyButton() {
        final JButton result = JButtonFactory.copyToClipboardButton(new JTextField());

        assertAll(() -> {
            assertNotNull(result);
            assertEquals(COPY, result.getIcon());
        });

    }
}