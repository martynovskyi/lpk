package com.motokyi.lpk.ui.credentials;


import com.motokyi.lpk.model.CredentialsEntry;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class CredsContentPanel extends JPanel {

    CredsContentPanel(CredentialsEntry model) {
        super();
        super.setBorder(BorderFactory.createDashedBorder(Color.black));
        super.setLayout(new BorderLayout());
        super.setName(model.getId().toString());
        super.add(new CredsControlsPanel(this), BorderLayout.NORTH);
        super.add(new CredsViewPanel(this, model), BorderLayout.CENTER);

        this.setVisible(false);

    }

    public void setExpanded(boolean expanded) {
        this.setVisible(expanded);
        this.repaint();
    }

}
