package com.motokyi.lpk.ui.credentials;

import com.motokyi.lpk.creds.CredService;
import com.motokyi.lpk.creds.CredsType;
import com.motokyi.lpk.creds.CredsValidator;
import com.motokyi.lpk.model.CredentialsEntry;
import com.motokyi.lpk.ui.gridbad.GridBadBuilder;
import com.motokyi.lpk.ui.utils.GBCFactory;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.motokyi.lpk.ui.utils.UIUtils.addDocumentListener;
import static com.motokyi.lpk.ui.utils.UIUtils.highlight;


public class AddCredsDialog extends JDialog {
    private final JTextField urlTF = new JTextField();
    private final JTextField nameTF = new JTextField();
    private final JTextField loginTF = new JTextField();
    private final JTextField passwordTF = new JTextField();
    private final JTextField commentTF = new JTextField();
    private final CredService credService;

    public AddCredsDialog(CredService credService, JFrame frame) {
        super(frame, "Create new credential entry", true);
        this.credService = credService;
        final GridBadBuilder gbBuilder = new GridBadBuilder((x, y) -> {
            switch (x) {
                case 0: {
                    return GBCFactory.gbcEast(x, y, new Insets(0, 0, 0, 7));
                }
                case 1: {
                    return GBCFactory.gbcWestBoth(x, y);
                }
                default: {
                    return GBCFactory.gbc(x, y);
                }
            }
        });

        urlTF.setPreferredSize(new Dimension(600, 24));
        gbBuilder.addRow(new JLabel("Web page"), urlTF);
        gbBuilder.addRow(new JLabel("Name"), nameTF);
        gbBuilder.addRow(new JLabel("Login"), loginTF);
        gbBuilder.addRow(new JLabel("Password"), passwordTF);
        gbBuilder.addRow(new JLabel("Comment"), commentTF);
        final JButton save = new JButton("Save");
        gbBuilder.addRow(save);
        save.addActionListener(new AddCredsDialogActionListener());
        addDocumentListener(new AddCredsDialogDocumentListener(), urlTF, nameTF, loginTF, passwordTF);

        super.setContentPane(gbBuilder.build());
        super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        super.setSize(800, 400);
        super.setLocationRelativeTo(null);
        super.pack();
        super.setVisible(true);
    }

    private boolean performValidation() {
        final boolean validName = CredsValidator.isValid(CredsType.NAME, nameTF.getText());
        highlight(validName, nameTF);

        final boolean validUrl = CredsValidator.isValid(CredsType.URL, urlTF.getText());
        highlight(validUrl, urlTF);

        final boolean validLogin = CredsValidator.isValid(CredsType.LOGIN, loginTF.getText());
        highlight(validLogin, loginTF);

        final boolean validPassword = CredsValidator.isValid(CredsType.PASSWORD, passwordTF.getText());
        highlight(validPassword, passwordTF);

        return validName && validUrl && validLogin && validPassword;
    }

    private class AddCredsDialogDocumentListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            performValidation();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            performValidation();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            performValidation();
        }
    }

    private class AddCredsDialogActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {


            final var creds = CredentialsEntry.builder()
                    .name(nameTF.getText().trim())
                    .url(urlTF.getText().trim())
                    .login(loginTF.getText().trim())
                    .password(passwordTF.getText().trim())
                    .comment(commentTF.getText().trim())
                    .build();
            if (performValidation() && credService.isValid(creds)) {
                credService.add(creds);
            }
        }
    }
}
