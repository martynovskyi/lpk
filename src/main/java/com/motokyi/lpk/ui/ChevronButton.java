package com.motokyi.lpk.ui;

import javax.swing.*;
import java.awt.*;

import static com.motokyi.lpk.ui.utils.Icons.LESS_CHEVRON;
import static com.motokyi.lpk.ui.utils.Icons.MORE_CHEVRON;
import static com.motokyi.lpk.ui.utils.UIUtils.HAND_CURSOR;

class ChevronButton extends JButton {
    ChevronButton() {

        super(MORE_CHEVRON);
        super.setMargin(new Insets(0, 0, 0, 0));
        super.setOpaque(false);
        super.setContentAreaFilled(false);
        super.setCursor(HAND_CURSOR);
//        super.setBorderPainted(false);

        super.addActionListener(e -> {
            if (this.getParent().getClass().equals(TitlePanel.class)) {
                TitlePanel titlePanel = (TitlePanel) this.getParent();
                if (titlePanel.getMainPanel().getContentPanel().isVisible()) {
                    super.setIcon(MORE_CHEVRON);
                    titlePanel.getMainPanel().getContentPanel().setExpanded(false);
                } else {
                    super.setIcon(LESS_CHEVRON);
                    titlePanel.getMainPanel().getContentPanel().setExpanded(true);
                }

                    super.repaint();
            }
        });

        super.setFocusPainted(true);
    }
}
