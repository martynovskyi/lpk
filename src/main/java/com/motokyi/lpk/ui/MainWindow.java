package com.motokyi.lpk.ui;

import com.motokyi.lpk.model.CredentialsEntry;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MainWindow {

    public MainWindow() {
        final JFrame window = new JFrame("L P K");
        window.setSize(800, 1000);
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        final TrayPanel contentPanel = new TrayPanel();
        window.add(contentPanel);
        window.setVisible(true);
        shipItems(contentPanel);
        window.setJMenuBar(new MenuBar());
        window.revalidate();
        window.repaint();
    }


    private static void shipItems(Container panel) {
        final Random random = new Random();
        final int alpha = 40;

        for (int i = 0; i < 5; i++) {
            final Color color = new Color(
                    random.nextInt(256),
                    random.nextInt(256),
                    random.nextInt(256),
                    alpha);

            final CredentialsEntry credentialsEntry = new CredentialsEntry();
            credentialsEntry.setName(i + " " + color.toString());

            final CredentialsItemPanel trayItem = new CredentialsItemPanel(credentialsEntry);

            trayItem.setBackground(color);
            panel.add(trayItem);

        }

        panel.revalidate();
        panel.repaint();
    }
}
