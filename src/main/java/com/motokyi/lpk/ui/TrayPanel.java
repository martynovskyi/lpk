package com.motokyi.lpk.ui;

import com.motokyi.lpk.ui.credentials.AddCredsButton;

import javax.swing.*;
import java.awt.*;

import static com.motokyi.lpk.Utils.Colors.TOP_CONTROLS_BACKGROUND;

public class TrayPanel extends JPanel {
    private JPanel topControls = new JPanel();
    private JPanel content = new JPanel();
    private JPanel controls = new JPanel();

    TrayPanel() {
        super();
        super.setLayout(new BorderLayout());
        topControls.setLayout(new BoxLayout(topControls, BoxLayout.LINE_AXIS));
        topControls.setBackground(TOP_CONTROLS_BACKGROUND);

        topControls.add(new JTextField());
        topControls.add(Box.createVerticalBox());
        topControls.add(new AddCredsButton());

        final JPanel contentTopAlignmentPanel = new JPanel(new BorderLayout());

        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));

        contentTopAlignmentPanel.add(content, BorderLayout.NORTH);
        final JButton accept = new JButton("Action");
        final JButton cancel = new JButton("Cancel");
        controls.setLayout(new FlowLayout());
        controls.add(accept);
        controls.add(cancel);


        final JScrollPane scrollPane = new JScrollPane(contentTopAlignmentPanel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        super.add(topControls, BorderLayout.NORTH);
        super.add(scrollPane, BorderLayout.CENTER);
        super.add(controls, BorderLayout.SOUTH);
    }

    @Override
    public Component add(Component comp) {
        return content.add(comp);
    }
}
