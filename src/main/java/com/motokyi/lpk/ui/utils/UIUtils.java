package com.motokyi.lpk.ui.utils;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Optional;
import java.util.function.Consumer;

import static com.motokyi.lpk.Utils.Colors.INVALID_TEXT_FIELD;
import static com.motokyi.lpk.Utils.Colors.TEXT_FIELD_BACKGROUND;
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
            if (type.isInstance(container)) {
                return Optional.of(type.cast(container));
            }
        }
        return Optional.empty();
    }

    public static Optional<JFrame> findParentFrame(JComponent component) {
        return findParent(component, JFrame.class);
    }

    public static void walk(JComponent component, Consumer<? super JComponent> consumer) {
        if (nonNull(component)) {
            consumer.accept(component);
            for (Component c : component.getComponents()) {
                walk((JComponent) c, consumer);
            }
        }
    }

    public static void highlight(boolean state, JComponent component) {
        if (component instanceof JTextField) {
            component.setBackground(state ? TEXT_FIELD_BACKGROUND : INVALID_TEXT_FIELD);
        }
    }

    public static void addDocumentListener(DocumentListener listener, JTextField... components) {
        for (JTextField component : components) {
            component.getDocument().addDocumentListener(listener);
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
