package com.motokyi.lpk.ui.utils;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class JPanelUtils {
    private JPanelUtils() {
    }

    public static JPanel wrap(JComponent... components) {
        final JPanel panel = new JPanel();
        for (JComponent component : components) {
            panel.add(component);
        }
        return panel;
    }

    public static JPanel wrapBox(JComponent... components) {
        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        for (JComponent component : components) {
            panel.add(component);
        }
        return panel;
    }
}
