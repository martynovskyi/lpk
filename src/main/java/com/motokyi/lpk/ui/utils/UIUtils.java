package com.motokyi.lpk.ui.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Optional;
import java.util.function.Consumer;

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

    public static void walk(JComponent component, Consumer<? super JComponent> consumer) {
        if (nonNull(component)) {
            consumer.accept(component);
            for (Component c : component.getComponents()) {
                walk((JComponent) c, consumer);
            }
        }
    }

    public static ImageIcon scaleImageIcon(ImageIcon src, int w, int h) {
        return new ImageIcon(scaleImage(src.getImage(), w, h));
    }

    public static Image scaleImage(Image src, int w, int h) {
        BufferedImage resized = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resized.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(src, 0, 0, w, h, null);
        g2.dispose();

        return resized;
    }
}
