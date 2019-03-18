package com.motokyi.lpk.ui;

import com.motokyi.lpk.model.CredentialsEntry;
import com.motokyi.lpk.ui.credentials.CredsItemPanel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
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

        for (int i = 0; i < 15; i++) {
            final Color color = new Color(
                    random.nextInt(256),
                    random.nextInt(256),
                    random.nextInt(256),
                    alpha);

            final CredentialsEntry credsEntry = new CredentialsEntry();
            credsEntry.setName(i + " " + color.toString());
            credsEntry.setURL("https://wayne.com/");
            credsEntry.setUsername("batman_777");
            credsEntry.setPassword("bruce_hero");
            credsEntry.setComment("Superman not a hero!");
            credsEntry.setCreated(LocalDateTime.now());

            final CredsItemPanel trayItem = new CredsItemPanel(credsEntry);

            trayItem.setBackground(color);
            panel.add(trayItem);
        }

        panel.revalidate();
        panel.repaint();
    }
}
