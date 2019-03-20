package com.motokyi.lpk.ui.utils;

import javax.swing.*;

import static com.motokyi.lpk.ui.utils.Icons.COPY;

public class JButtonFactory {
    private JButtonFactory() {
    }

    public static JButton copyButton() {
        final JButton button = new JButton(COPY);
        button.setToolTipText("Copy value");
        return button;
    }
}
