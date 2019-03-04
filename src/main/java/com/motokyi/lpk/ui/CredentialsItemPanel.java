package com.motokyi.lpk.ui;

import com.motokyi.lpk.model.CredentialsEntry;

import javax.swing.*;
import java.awt.*;

import static java.util.Objects.nonNull;

class CredentialsItemPanel extends JPanel {
    private final TitlePanel titlePanel;
    private final CredsContentPanel contentPanel;
    private final CredentialsEntry model;


    CredentialsItemPanel(CredentialsEntry creds) {
        super();
        super.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        super.setAlignmentY(Component.TOP_ALIGNMENT);
        this.model = creds;
        this.titlePanel = new TitlePanel(model.getName());
        this.contentPanel = new CredsContentPanel();
        super.add(titlePanel);
        super.add(contentPanel);
    }


    @Override
    public void setBackground(Color bg) {
        if (nonNull(titlePanel) && nonNull(contentPanel)) {
            this.titlePanel.setBackground(bg);
        }
    }

    public void expandCollapse() {
        final boolean newState = !contentPanel.isVisible();
        contentPanel.setExpanded(newState);
    }


    public TitlePanel getTitlePanel() {
        return titlePanel;
    }

    CredsContentPanel getContentPanel() {
        return contentPanel;
    }

    @Override
    public Component add(Component comp) {
        return super.add(comp);
    }
}