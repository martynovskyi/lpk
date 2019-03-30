package com.motokyi.lpk.ui;

import com.motokyi.lpk.ui.credentials.AddCredsButton;
import org.springframework.stereotype.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;

import static com.motokyi.lpk.Utils.Colors.TOP_CONTROLS_BACKGROUND;

@Component
public class TrayPanel extends JPanel {
    private JPanel content = new JPanel();

    TrayPanel(AddCredsButton addCredsButton) {
        super();
        super.setLayout(new BorderLayout());
        JPanel topControls = new JPanel();
        topControls.setLayout(new BoxLayout(topControls, BoxLayout.LINE_AXIS));
        topControls.setBackground(TOP_CONTROLS_BACKGROUND);

        topControls.add(new JTextField());
        topControls.add(Box.createVerticalBox());
        topControls.add(addCredsButton);

        final JPanel contentTopAlignmentPanel = new JPanel(new BorderLayout());

        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));

        contentTopAlignmentPanel.add(content, BorderLayout.NORTH);
        final JButton accept = new JButton("Action");
        final JButton cancel = new JButton("Cancel");
        JPanel controls = new JPanel();
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
    public java.awt.Component add(java.awt.Component comp) {
        return content.add(comp);
    }
}
