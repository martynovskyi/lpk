package com.motokyi.lpk.ui;

import com.motokyi.lpk.model.CredentialStorage;
import com.motokyi.lpk.ui.credentials.CredsItemPanel;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

@Lazy
@Component
public class MainWindow extends JFrame {
//    private final CredentialStorage storage;

    public MainWindow(TrayPanel trayPanel, CredentialStorage storage) {
        super("L P K");
        super.setSize(800, 1000);
        super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        super.setJMenuBar(new MenuBar());
        super.add(trayPanel);
        super.setVisible(false);
        super.revalidate();
        super.repaint();
        storage.getUnmodCredentials().forEach(cred -> trayPanel.add(new CredsItemPanel(cred)));
    }
}
