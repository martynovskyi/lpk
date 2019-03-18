package com.motokyi.lpk.ui.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static com.motokyi.lpk.ui.utils.Icons.COPY;

public class UIUtils {


    private UIUtils() {
    }

    public static class Components {
        public static JTextField disabledTextField(String text) {
            final JTextField textField = new JTextField();
            textField.setText(text);
            textField.setEditable(false);
            return textField;
        }

        public static JButton copyButton() {
            final JButton button = new JButton(COPY);
            button.setToolTipText("Copy value");
            return button;
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

    static class Graphics {
        static ImageIcon scaleImageIcon(Image src, int w, int h) {
            return new ImageIcon(scaleImage(src, w, h));
        }

        static Image scaleImage(Image src, int w, int h) {
            BufferedImage resized = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = resized.createGraphics();

            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(src, 0, 0, w, h, null);
            g2.dispose();

            return resized;
        }
    }
}
