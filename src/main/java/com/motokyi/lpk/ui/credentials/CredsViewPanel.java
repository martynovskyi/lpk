package com.motokyi.lpk.ui.credentials;

import javax.swing.*;
import java.awt.*;

public class CredsViewPanel extends JPanel {
    public static final Dimension PREFERRED_SIZE = new Dimension(250, 25);
    private final CredsContentPanel rootPanel;

    public CredsViewPanel(CredsContentPanel rootPanel) {
        super();
        this.rootPanel = rootPanel;

        super.setBorder(BorderFactory.createDashedBorder(Color.black));
        super.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        final JLabel siteLabel = new JLabel("Web page");
        final JTextField siteTextField = new JTextField();
        siteTextField.setPreferredSize(PREFERRED_SIZE);

        final JPanel sitePanel = new JPanel();
        sitePanel.setLayout(new BoxLayout(sitePanel, BoxLayout.LINE_AXIS));
        sitePanel.add(siteLabel);
        sitePanel.add(siteTextField);
        super.add(sitePanel);

        final JLabel usernameLabel = new JLabel("Username");
        final JTextField usernameTextField = new JTextField();
        final JPanel userNamePanel = new JPanel();
        userNamePanel.setLayout(new BoxLayout(userNamePanel, BoxLayout.LINE_AXIS));
        userNamePanel.add(usernameLabel);
        userNamePanel.add(usernameTextField);
        super.add(userNamePanel);

        final JLabel passwordLabel = new JLabel("Password");
        final JTextField passwordTextField = new JTextField();
        final JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.LINE_AXIS));
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordTextField);
        super.add(passwordPanel);
    }
}
