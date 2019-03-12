package com.motokyi.lpk.ui;

import javax.swing.*;
import java.awt.*;

class TitlePanel extends JPanel {

    TitlePanel(String name) {
        super();
        super.setBorder(BorderFactory.createLineBorder(Color.black));
        final FlowLayout headerLayout = new FlowLayout();
        headerLayout.setAlignment(FlowLayout.LEFT);
        super.setLayout(headerLayout);
        final JLabel label = new JLabel(name);

        super.add(new ChevronButton());
        super.add(label);
    }

    CredentialsItemPanel getMainPanel() {
        if (super.getParent().getClass().equals(CredentialsItemPanel.class)) {
            return (CredentialsItemPanel) this.getParent();
        }
        return null;
    }
}
