package com.motokyi.lpk.ui.credentials;

import com.motokyi.lpk.model.CredentialsEntry;
import com.motokyi.lpk.ui.TitlePanel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.util.Random;

public class CredsItemPanel extends JPanel {
    private static final int ALPHA = 40;
    private static final Random RANDOM = new Random();
    private final TitlePanel titlePanel;
    private final CredsContentPanel contentPanel;
    private final CredentialsEntry model;

    public CredsItemPanel(CredentialsEntry creds) {
        super();
        this.model = creds;
        super.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        super.setAlignmentY(Component.TOP_ALIGNMENT);
        super.setName(creds.getId().toString());
        final Color color = new Color(
                RANDOM.nextInt(256),
                RANDOM.nextInt(256),
                RANDOM.nextInt(256),
                ALPHA);
        this.titlePanel = new TitlePanel(model.getName());
        this.titlePanel.setBackground(color);
        this.titlePanel.setForeground(color);
        this.contentPanel = new CredsContentPanel(model);
        super.add(titlePanel);
        super.add(contentPanel);
    }

    public CredsContentPanel getContentPanel() {
        return contentPanel;
    }

    @Override
    public Component add(Component comp) {
        if (comp instanceof CredsItemPanel) {
            return super.add(comp);
        }
        return comp;
    }
}