package com.motokyi.lpk.ui.credentials;

import com.motokyi.lpk.model.CredentialsEntry;
import com.motokyi.lpk.ui.gridbad.GridBadBuilder;
import com.motokyi.lpk.ui.gridbad.GridBadBuilder.RowRule;
import com.motokyi.lpk.ui.utils.GBCFactory;
import com.motokyi.lpk.ui.utils.JLabelFactory;

import javax.swing.*;
import java.awt.*;

import static com.motokyi.lpk.ui.utils.JButtonFactory.copyButton;
import static com.motokyi.lpk.ui.utils.UIUtils.disabledTextField;

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

        final JTextField siteTextField = disabledTextField(model.getURL());
        siteTextField.setPreferredSize(PREFERRED_SIZE);

        final GridBadBuilder gbBuilder = new GridBadBuilder(new CredsViewPanelRowRules());

        gbBuilder.addRow(new JLabel("Web page"),
                siteTextField,
                copyButton(),
                new JLabel("Created"),
                JLabelFactory.of(model.getCreated()));

        gbBuilder.addRow(new JLabel("Username"),
                disabledTextField(model.getUsername()),
                copyButton(),
                new JLabel("Updated"),
                JLabelFactory.of(model.getUpdated()));
        gbBuilder.addRow(new JLabel("Password"), disabledTextField(model.getPassword()), copyButton());
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
