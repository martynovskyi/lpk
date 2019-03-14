package com.motokyi.lpk.ui.credentials;


import javax.swing.*;
import java.awt.*;

public class CredsContentPanel extends JPanel {

    public CredsContentPanel() {
        super();
        super.setBorder(BorderFactory.createDashedBorder(Color.black));
        super.setLayout(new BorderLayout());

        super.add(new CredsControlsPanel(this), BorderLayout.NORTH);
        super.add(new CredsViewPanel(this), BorderLayout.WEST);

        this.setVisible(false);

    }

    public void setExpanded(boolean expanded) {
        this.setVisible(expanded);
        this.repaint();
    }

}