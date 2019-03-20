package com.motokyi.lpk.ui.utils;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GBCFactoryTest {
    private static final int X = 1;
    private static final int Y = 2;
    private static final Insets INSETS = new Insets(1, 2, 3, 4);

    @Test
    void gbc() {
        final GridBagConstraints result = GBCFactory.gbc(X, Y);

        assertAll(() -> {
            assertNotNull(result);
            assertEquals(X, result.gridx);
            assertEquals(Y, result.gridy);
        });
    }

    @Test
    void gbcWithInsets() {
        final var result = GBCFactory.gbc(X, Y, INSETS);

        assertAll(() -> {
            assertNotNull(result);
            assertEquals(X, result.gridx);
            assertEquals(Y, result.gridy);
            assertEquals(INSETS, result.insets);
        });
    }

    @Test
    void gbcEast() {
        final var result = GBCFactory.gbcEast(X, Y);

        assertAll(() -> {
            assertNotNull(result);
            assertEquals(X, result.gridx);
            assertEquals(Y, result.gridy);
            assertEquals(GridBagConstraints.EAST, result.anchor);
        });
    }

    @Test
    void gbcEastWithInsets() {
        final var result = GBCFactory.gbcEast(X, Y, INSETS);

        assertAll(() -> {
            assertNotNull(result);
            assertEquals(X, result.gridx);
            assertEquals(Y, result.gridy);
            assertEquals(INSETS, result.insets);
            assertEquals(GridBagConstraints.EAST, result.anchor);
        });
    }

    @Test
    void gbcWest() {
        final var result = GBCFactory.gbcWest(X, Y);

        assertAll(() -> {
            assertNotNull(result);
            assertEquals(X, result.gridx);
            assertEquals(Y, result.gridy);
            assertEquals(GridBagConstraints.WEST, result.anchor);
        });
    }

    @Test
    void gbcWestWithInsets() {
        final var result = GBCFactory.gbcWest(X, Y, INSETS);

        assertAll(() -> {
            assertNotNull(result);
            assertEquals(X, result.gridx);
            assertEquals(Y, result.gridy);
            assertEquals(INSETS, result.insets);
            assertEquals(GridBagConstraints.WEST, result.anchor);
        });
    }

    @Test
    void gbcWestBoth() {
        final var result = GBCFactory.gbcWestBoth(X, Y);

        assertAll(() -> {
            assertNotNull(result);
            assertEquals(X, result.gridx);
            assertEquals(Y, result.gridy);
            assertEquals(GridBagConstraints.WEST, result.anchor);
            assertEquals(GridBagConstraints.BOTH, result.fill);
        });
    }
}