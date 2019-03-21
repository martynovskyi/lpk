package com.motokyi.lpk.ui;

import com.motokyi.lpk.ui.gridbad.GridBadBuilder;
import com.motokyi.lpk.ui.utils.GBCFactory;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

import static com.motokyi.lpk.ui.utils.Icons.PLUS_ICON;
import static com.motokyi.lpk.ui.utils.JTextFieldFactory.disabledTextField;
import static com.motokyi.lpk.ui.utils.UIUtils.HAND_CURSOR;
import static com.motokyi.lpk.ui.utils.UIUtils.findParent;

public class AddCredsButton extends JButton {
    public AddCredsButton() {
        super(PLUS_ICON);
        super.setCursor(HAND_CURSOR);

        super.addActionListener(e -> {

            Class<JFrame> type = JFrame.class;
            final Optional<JFrame> parent = findParent(this, type);


            parent.ifPresent(frame -> {

                final GridBadBuilder gbBuilder = new GridBadBuilder((x, y) -> {
                    switch (x) {
                        case 0: {
                            return GBCFactory.gbcEast(x, y);
                        }
                        case 1: {
                            return GBCFactory.gbcWestBoth(x, y);
                        }
                        case 2: {
                            return GBCFactory.gbc(x, y);
                        }
                        default: {
                            return GBCFactory.gbc(x, y);
                        }
                    }
                });

                final JTextField siteTextField = disabledTextField("");
                siteTextField.setPreferredSize(new Dimension(600, 24));
                gbBuilder.addRow(new JLabel("Web page"), siteTextField);
                gbBuilder.addRow(new JLabel("Username"), disabledTextField(""));
                gbBuilder.addRow(new JLabel("Password"), disabledTextField(""));
                gbBuilder.addRow(new JLabel("Comment"), disabledTextField(""));
                gbBuilder.addRow(new JButton("Save"));


                final JDialog dialog = new JDialog(frame, "Create new credential entry", true);
                dialog.setContentPane(gbBuilder.build());
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.pack();
                dialog.setVisible(true);

            });
        });
    }
}
