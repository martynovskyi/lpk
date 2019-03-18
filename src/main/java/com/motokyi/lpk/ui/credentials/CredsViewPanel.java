package com.motokyi.lpk.ui.credentials;

import com.motokyi.lpk.model.CredentialsEntry;
import com.motokyi.lpk.ui.utils.JLabelFactory;

import javax.swing.*;
import java.awt.*;

import static com.motokyi.lpk.ui.utils.UIUtils.Components.*;

class CredsViewPanel extends JPanel {
    private static final Dimension PREFERRED_SIZE = new Dimension(250, 25);
    private final CredsContentPanel rootPanel;
    private final CredentialsEntry model;

    CredsViewPanel(CredsContentPanel rootPanel, CredentialsEntry model) {
        super();
        this.rootPanel = rootPanel;
        this.model = model;

        super.setBorder(BorderFactory.createDashedBorder(Color.black, 3, 3));
        super.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        final JTextField siteTextField = disabledTextField(model.getURL());
        siteTextField.setPreferredSize(PREFERRED_SIZE);

        final JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
        leftPanel.add(wrapBox(new JLabel("Web page"), siteTextField, copyButton()));
        leftPanel.add(wrapBox(new JLabel("Username"), disabledTextField(model.getUsername()), copyButton()));
        leftPanel.add(wrapBox(new JLabel("Password"), disabledTextField(model.getPassword()), copyButton()));
        leftPanel.add(wrapBox(new JLabel("Comment"), disabledTextField(model.getComment())));
        super.add(leftPanel);
        final JPanel spacer = new JPanel();
        spacer.setBorder(BorderFactory.createLineBorder(Color.black));
        super.add(spacer);

        final JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
        rightPanel.add(wrapBox(new JLabel("Created"), JLabelFactory.of(model.getCreated())));
        rightPanel.add(wrapBox(new JLabel("Updated"), JLabelFactory.of(model.getUpdated())));
        super.add(rightPanel);
    }

}
