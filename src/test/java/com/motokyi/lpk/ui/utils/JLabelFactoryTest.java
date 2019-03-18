package com.motokyi.lpk.ui.utils;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class JLabelFactoryTest {

    @Test
    void fromLDT() {
        final JLabel result = JLabelFactory.of(LocalDateTime.now());
        assertNotNull(result);
    }

    @Test
    void fromLDTNull() {
        final JLabel result = JLabelFactory.of(null);
        assertNotNull(result);
    }

}