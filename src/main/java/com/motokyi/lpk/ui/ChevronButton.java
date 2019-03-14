package com.motokyi.lpk.ui;

import javax.swing.*;

class ChevronButton extends JButton {
    private static ImageIcon more = new ImageIcon(ChevronButton.class.getResource("/2x/chevron_more_black.png"));
    private static ImageIcon less = new ImageIcon(ChevronButton.class.getResource("/2x/chevron_less_black.png"));

    ChevronButton() {
        super(more);
        super.setOpaque(false);
        super.setContentAreaFilled(false);
        super.setBorderPainted(true);

        super.addActionListener(e -> {
            if (this.getParent().getClass().equals(TitlePanel.class)) {
                TitlePanel titlePanel = (TitlePanel) this.getParent();
                if (titlePanel.getMainPanel().getContentPanel().isVisible()) {
                    super.setIcon(more);
                    super.repaint();
                    titlePanel.getMainPanel().getContentPanel().setExpanded(false);
                } else {
                    super.setIcon(less);
                    super.repaint();
                    titlePanel.getMainPanel().getContentPanel().setExpanded(true);
                }

            }
        });

        super.setFocusPainted(true);
    }
}
