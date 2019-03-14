package com.motokyi.lpk.ui.credentials;

import javax.swing.*;

public class CredsControlsPanel extends JPanel {
    private final CredsContentPanel rootPanel;

    public CredsControlsPanel(CredsContentPanel rootPanel) {
        super();
        this.rootPanel = rootPanel;
        super.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        super.add(new JButton("Edit"));
        super.add(new JButton("Delete"));
    }
}
