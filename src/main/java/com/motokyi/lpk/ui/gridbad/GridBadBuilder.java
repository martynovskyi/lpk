package com.motokyi.lpk.ui.gridbad;

import javax.swing.*;
import java.awt.*;

import static java.util.Objects.nonNull;

public class GridBadBuilder {
    private final JPanel panel;
    private final RowRule rule;
    private int row;

    public GridBadBuilder(RowRule rule) {
        this.panel = new JPanel(new GridBagLayout());
        this.rule = rule;
    }

    public GridBadBuilder(JPanel panel, RowRule rule) {
        panel.setLayout(new GridBagLayout());
        this.panel = panel;
        this.rule = rule;
    }

    public void addRow(JComponent... components) {
        if (nonNull(components) && components.length > 0) {
            for (int col = 0; col < components.length; col++) {
                panel.add(components[col], rule.handle(col, row));
            }
            row++;
        }
    }

    public JPanel build() {
        return panel;
    }

    public interface RowRule {
        GridBagConstraints handle(int x, int y);
    }

}
