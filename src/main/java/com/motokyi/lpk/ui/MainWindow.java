package com.motokyi.lpk.ui;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

@Lazy
@Component
public class MainWindow extends JFrame {

    public MainWindow(TrayPanel trayPanel) {
        super("L P K");
        super.setSize(800, 1000);
        super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        super.setJMenuBar(new MenuBar());
        super.add(trayPanel);
        super.setVisible(false);
        super.revalidate();
        super.repaint();
    }
}
