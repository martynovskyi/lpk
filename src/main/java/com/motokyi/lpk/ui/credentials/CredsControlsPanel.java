package com.motokyi.lpk.ui.credentials;

import com.motokyi.lpk.ui.utils.Icons;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

class CredsControlsPanel extends JPanel {
    private final CredsContentPanel rootPanel;

    CredsControlsPanel(CredsContentPanel rootPanel) {
        super();
        this.rootPanel = rootPanel;
        super.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        super.add(Box.createHorizontalGlue());
        final JButton editButton = new JButton(Icons.EDIT);
        editButton.setToolTipText("Edit credentials");
        super.add(editButton);
        super.add(Box.createHorizontalBox());
        final JButton deleteButton = new JButton(Icons.DELETE);
        deleteButton.setToolTipText("Delete credentials");
        super.add(deleteButton);

    }
}
