package com.motokyi.lpk.ui.credentials;

import com.motokyi.lpk.model.CredentialsEntry;
import com.motokyi.lpk.ui.gridbad.GridBadBuilder;
import com.motokyi.lpk.ui.gridbad.GridBadBuilder.RowRule;
import com.motokyi.lpk.ui.utils.GBCFactory;
import com.motokyi.lpk.ui.utils.JLabelFactory;

import javax.swing.*;
import java.awt.*;

import static com.motokyi.lpk.ui.utils.JButtonFactory.copyToClipboardButton;
import static com.motokyi.lpk.ui.utils.JTextFieldFactory.disabledTextField;

class CredsViewPanel extends JPanel {
    private static final Dimension PREFERRED_SIZE = new Dimension(350, 25);
    private static final Insets LABEL_INSETS = new Insets(0, 0, 0, 5);
    private static final Insets SECTION_INSETS = new Insets(0, 0, 0, 25);
    private final CredsContentPanel rootPanel;
    private final CredentialsEntry model;

    CredsViewPanel(CredsContentPanel rootPanel, CredentialsEntry model) {
        super();
        this.rootPanel = rootPanel;
        this.model = model;

        super.setBorder(BorderFactory.createDashedBorder(Color.black, 3, 3));
        super.setLayout(new FlowLayout(FlowLayout.LEFT));


        final GridBadBuilder gbBuilder = new GridBadBuilder(new CredsViewPanelRowRules());

        final JLabel webPageLabel = new JLabel("Web page");
        final JTextField siteTextField = disabledTextField(webPageLabel.getText(), model.getURL());
        siteTextField.setPreferredSize(PREFERRED_SIZE);
        gbBuilder.addRow(webPageLabel,
                siteTextField,
                copyToClipboardButton(siteTextField),
                new JLabel("Created"),
                JLabelFactory.of(model.getCreated()));

        final JLabel usernameLabel = new JLabel("Username");
        final JTextField userNameTF = disabledTextField(usernameLabel.getText(), model.getUsername());
        gbBuilder.addRow(usernameLabel,
                userNameTF,
                copyToClipboardButton(userNameTF),
                new JLabel("Updated"),
                JLabelFactory.of(model.getUpdated()));

        final JLabel passwordLabel = new JLabel("Password");
        final JTextField passwordTF = disabledTextField(passwordLabel.getText(), model.getPassword());

        gbBuilder.addRow(passwordLabel, passwordTF, copyToClipboardButton(passwordTF));
        gbBuilder.addRow(new JLabel("Comment"), disabledTextField(model.getComment()));
        super.add(gbBuilder.build());
    }

    private class CredsViewPanelRowRules implements RowRule {

        @Override
        public GridBagConstraints handle(int x, int y) {
            switch (x) {
                case 0: {
                    return GBCFactory.gbcEast(x, y, LABEL_INSETS);
                }
                case 1: {
                    return GBCFactory.gbcWestBoth(x, y);
                }
                case 2: {
                    return GBCFactory.gbc(x, y, SECTION_INSETS);
                }
                case 3: {
                    return GBCFactory.gbcEast(x, y, LABEL_INSETS);
                }
                case 4: {
                    return GBCFactory.gbcWest(x, y, LABEL_INSETS);
                }
                default: {
                    return GBCFactory.gbc(x, y);
                }
            }
        }
    }
}
