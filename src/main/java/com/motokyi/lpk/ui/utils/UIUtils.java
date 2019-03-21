package com.motokyi.lpk.ui.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class UIUtils {
    public static final Cursor HAND_CURSOR = new Cursor(Cursor.HAND_CURSOR);

    private UIUtils() {
    }

    public static <T extends Container> Optional<T> findParent(JComponent component, Class<T> type) {
        if (isNull(type)) {
            return Optional.empty();
        }
        if (type.equals(component.getClass())) {
            return Optional.of(type.cast(component));
        }
        Container container = component;
        while (nonNull(container.getParent())) {
            container = container.getParent();
            if (type.equals(container.getClass())) {
                return Optional.of(type.cast(container));
            }

        }
        return Optional.empty();
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
