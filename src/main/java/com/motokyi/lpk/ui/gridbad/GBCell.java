package com.motokyi.lpk.ui.gridbad;

import javax.swing.JComponent;
import java.awt.GridBagConstraints;

public class GBCell {
    public static final GBCell EMPTY = new GBCell(null, null);
    private final JComponent component;
    private final GridBagConstraints constraints;

    private GBCell(JComponent component, GridBagConstraints constraints) {
        this.component = component;
        this.constraints = constraints;
    }

    public static GBCell of(JComponent component, GridBagConstraints constraints) {
        return new GBCell(component, constraints);
    }


    public JComponent getComponent() {
        return this.component;
    }

    public GridBagConstraints getConstraints(int x, int y) {
        this.constraints.gridx = x;
        this.constraints.gridy = y;
        return this.constraints;
    }
}
