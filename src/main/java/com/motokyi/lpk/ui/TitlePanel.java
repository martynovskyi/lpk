package com.motokyi.lpk.ui;

import com.motokyi.lpk.ui.credentials.CredsItemPanel;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;

public class TitlePanel extends JPanel {

    public TitlePanel(String name) {
        super();
        super.setBorder(BorderFactory.createLineBorder(Color.black));
        final FlowLayout headerLayout = new FlowLayout();
        headerLayout.setAlignment(FlowLayout.LEFT);
        super.setLayout(headerLayout);
        final JLabel label = new JLabel(name);

        super.add(new ChevronButton());
        super.add(label);
    }

    CredsItemPanel getMainPanel() {
        if (super.getParent().getClass().equals(CredsItemPanel.class)) {
            return (CredsItemPanel) this.getParent();
        }
        return null;
    }
}
