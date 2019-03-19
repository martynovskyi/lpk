package com.motokyi.lpk.ui.credentials;


import com.motokyi.lpk.model.CredentialsEntry;

import javax.swing.*;
import java.awt.*;

public class CredsContentPanel extends JPanel {

    CredsContentPanel(CredentialsEntry model) {
        super();
        super.setBorder(BorderFactory.createDashedBorder(Color.black));
        super.setLayout(new BorderLayout());

        super.add(new CredsControlsPanel(this), BorderLayout.NORTH);
        super.add(new CredsViewPanel(this, model), BorderLayout.CENTER);

        this.setVisible(false);

    }

    public void setExpanded(boolean expanded) {
        this.setVisible(expanded);
        this.repaint();
    }

}
