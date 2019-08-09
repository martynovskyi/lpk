package com.motokyi.lpk.ui.gridbad;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import static java.util.Objects.nonNull;

public class GridBadBuilder {
    private final JPanel panel;
    private final RowRule rule;
    private int row;

    public GridBadBuilder(RowRule rule) {
        this.panel = new JPanel(new GridBagLayout());
        this.rule = rule;
    }

    public void addRow(JComponent... components) {
        if (nonNull(components) && components.length > 0) {
            for (int col = 0; col < components.length; col++) {
                final GridBagConstraints constraints = rule.handle(col, row);
                panel.add(components[col], constraints);
            }
            row++;
        }
    }

    public void addRow(GBCell... cells) {
        if (nonNull(cells) && cells.length > 0) {
            for (int col = 0; col < cells.length; col++) {
                final GBCell cell = cells[col];
                if (GBCell.EMPTY != cell) {
                    panel.add(cell.getComponent(), cell.getConstraints(col, row));
                }
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
