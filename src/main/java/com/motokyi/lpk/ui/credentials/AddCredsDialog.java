package com.motokyi.lpk.ui.credentials;

import com.motokyi.lpk.ui.gridbad.GridBadBuilder;
import com.motokyi.lpk.ui.utils.GBCFactory;

import javax.swing.*;
import java.awt.*;

public class AddCredsDialog extends JDialog {
    public AddCredsDialog(JFrame frame) {
        super(frame, "Create new credential entry", true);
        final GridBadBuilder gbBuilder = new GridBadBuilder((x, y) -> {
            switch (x) {
                case 0: {
                    return GBCFactory.gbcEast(x, y, new Insets(0, 0, 0, 7));
                }
                case 1: {
                    return GBCFactory.gbcWestBoth(x, y);
                }
                default: {
                    return GBCFactory.gbc(x, y);
                }
            }
        });

        final JTextField siteTextField = new JTextField();
        siteTextField.setPreferredSize(new Dimension(600, 24));
        gbBuilder.addRow(new JLabel("Web page"), siteTextField);
        gbBuilder.addRow(new JLabel("Name"), new JTextField());
        gbBuilder.addRow(new JLabel("Username"), new JTextField());
        gbBuilder.addRow(new JLabel("Password"), new JTextField());
        gbBuilder.addRow(new JLabel("Comment"), new JTextField());
        final JButton save = new JButton("Save");
        gbBuilder.addRow(save);

        super.setContentPane(gbBuilder.build());
        super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        super.setSize(800, 400);
        super.setLocationRelativeTo(null);
        super.pack();
        super.setVisible(true);
    }
}
