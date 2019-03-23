package com.motokyi.lpk.ui.credentials;

import javax.swing.*;
import java.util.Optional;

import static com.motokyi.lpk.ui.utils.Icons.PLUS_ICON;
import static com.motokyi.lpk.ui.utils.UIUtils.HAND_CURSOR;
import static com.motokyi.lpk.ui.utils.UIUtils.findParent;

public class AddCredsButton extends JButton {
    public AddCredsButton() {
        super(PLUS_ICON);
        super.setCursor(HAND_CURSOR);

        super.addActionListener(e -> {
            Class<JFrame> type = JFrame.class;
            final Optional<JFrame> mainFrame = findParent(this, type);
            mainFrame.ifPresent(AddCredsDialog::new);
        });
    }
}
