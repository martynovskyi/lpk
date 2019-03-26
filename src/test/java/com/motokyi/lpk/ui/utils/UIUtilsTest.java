package com.motokyi.lpk.ui.utils;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UIUtilsTest {

    @Test
    void findParent() {
        class TestPanel extends JPanel {
        }
        final JPanel target = new TestPanel();
        target.add(new JPanel());
        target.add(new JPanel());
        final JPanel comp = new JPanel();
        target.add(comp);
        comp.add(new JPanel());
        final JPanel node = new JPanel();
        comp.add(node);
        final Optional<TestPanel> parent = UIUtils.findParent(node, TestPanel.class);
        assertAll(() -> {
            assertTrue(parent.isPresent());
            assertEquals(target, parent.get());
        });
    }

    @Test
    void walk() {
        final String text = "Label Text";

        final JPanel mainPanel = new JPanel();
        mainPanel.add(new JButton());
        mainPanel.add(new JTextField());
        final JPanel comp = new JPanel();
        mainPanel.add(comp);
        final JLabel label1 = new JLabel();
        comp.add(label1);
        final JPanel node = new JPanel();
        final JLabel label2 = new JLabel();
        node.add(label2);
        comp.add(node);
        UIUtils.walk(mainPanel, e -> {
            if (e instanceof JLabel) {
                ((JLabel) e).setText(text);
            }
        });
        assertAll(() -> {
            assertEquals(text, label1.getText());
            assertEquals(text, label2.getText());
        });
    }

    @Test
    void scaleImageIcon() {
        final ImageIcon icon = new ImageIcon(UIUtilsTest.class.getResource("/icons/test-icon.png"));
        final int edgeLength = 10;
        final ImageIcon result = UIUtils.scaleImageIcon(icon, edgeLength, edgeLength);

        assertAll(() -> {
            assertNotNull(result);
            assertEquals(edgeLength, result.getIconHeight());
            assertEquals(edgeLength, result.getIconHeight());
        });
    }

    @Test
    void scaleImage() {
        final ImageIcon icon = new ImageIcon(UIUtilsTest.class.getResource("/icons/test-icon.png"));
        final int edgeLength = 16;
        final Image result = UIUtils.scaleImage(icon.getImage(), edgeLength, edgeLength);

        assertAll(() -> {
            assertNotNull(result);
            final ImageIcon scaledIcon = new ImageIcon(result);
            assertEquals(edgeLength, scaledIcon.getIconHeight());
            assertEquals(edgeLength, scaledIcon.getIconWidth());
        });
    }

    @Test
    void scaleImage2() {
        final ImageIcon icon = new ImageIcon(UIUtilsTest.class.getResource("/icons/test-icon.png"));
        final int edgeLength = 16;
        final Image result = icon.getImage().getScaledInstance(edgeLength, edgeLength, 0);
        assertAll(() -> {
            assertNotNull(result);
            final ImageIcon scaledicon = new ImageIcon(result);
            assertEquals(edgeLength, scaledicon.getIconHeight());
            assertEquals(edgeLength, scaledicon.getIconWidth());
        });
    }
}