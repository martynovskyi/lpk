package com.motokyi.lpk.ui.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

import static com.motokyi.lpk.ui.utils.Icons.COPY;

public class JButtonFactory {
    private JButtonFactory() {
    }

    public static JButton copyToClipboardButton(JTextField textField) {
        final JButton button = new JButton(COPY);
        button.setToolTipText("Copy value from " + textField.getName());
        button.addActionListener(e ->
                Toolkit.getDefaultToolkit()
                        .getSystemClipboard()
                        .setContents(new StringSelection(textField.getText()), null));
        return button;
    }
}
