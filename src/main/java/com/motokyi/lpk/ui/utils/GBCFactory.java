package com.motokyi.lpk.ui.utils;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GBCFactory {
    private static final GridBagConstraints DEFAULTS = new GridBagConstraints();

    private GBCFactory() {
    }


/* DEFAULT Constructor
       return new GridBagConstraints(DEFAULTS.gridx,
                DEFAULTS.gridy,
                DEFAULTS.gridwidth,
                DEFAULTS.gridheight,
                DEFAULTS.fill,
                DEFAULTS.ipadx,
                DEFAULTS.ipady,
                DEFAULTS.insets,
                DEFAULTS.anchor,
                DEFAULTS.weightx,
                DEFAULTS.weighty);*/

    public static GridBagConstraints gbc(int x, int y) {
        final var gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        return gbc;
    }

    public static GridBagConstraints gbc(int x, int y, Insets insets) {
        final var gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.insets = insets;
        return gbc;

    }

    public static GridBagConstraints gbcEast(int x, int y) {
        final var gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.EAST;
        return gbc;
    }

    public static GridBagConstraints gbcEast(int x, int y, Insets insets) {
        return new GridBagConstraints(x, y,
                DEFAULTS.gridwidth,
                DEFAULTS.gridheight,
                DEFAULTS.weightx,
                DEFAULTS.weighty,
                GridBagConstraints.EAST,
                DEFAULTS.fill,
                insets,
                DEFAULTS.ipadx,
                DEFAULTS.ipady);

    }

    public static GridBagConstraints gbcWest(int x, int y) {
        final var gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.WEST;
        return gbc;
    }

    public static GridBagConstraints gbcWest(int x, int y, Insets insets) {
        return new GridBagConstraints(x, y,
                DEFAULTS.gridwidth,
                DEFAULTS.gridheight,
                DEFAULTS.weightx,
                DEFAULTS.weighty,
                GridBagConstraints.WEST,
                DEFAULTS.fill,
                insets,
                DEFAULTS.ipadx,
                DEFAULTS.ipady);
    }

    public static GridBagConstraints gbcWestBoth(int x, int y) {
        final var gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        return gbc;
    }
}
