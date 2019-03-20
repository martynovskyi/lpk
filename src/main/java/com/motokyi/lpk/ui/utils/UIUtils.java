package com.motokyi.lpk.ui.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class UIUtils {
    private UIUtils() {
    }

    public static JTextField disabledTextField(String text) {
        final JTextField textField = new JTextField();
        textField.setText(text);
        textField.setEditable(false);
        return textField;
    }

    static ImageIcon scaleImageIcon(Image src, int w, int h) {
        return new ImageIcon(scaleImage(src, w, h));
    }

    private static Image scaleImage(Image src, int w, int h) {
        BufferedImage resized = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resized.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(src, 0, 0, w, h, null);
        g2.dispose();

        return resized;
    }
}
