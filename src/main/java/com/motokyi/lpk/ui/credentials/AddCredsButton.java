package com.motokyi.lpk.ui.credentials;

import com.motokyi.lpk.creds.CredService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.JButton;

import static com.motokyi.lpk.ui.utils.Icons.PLUS_ICON;
import static com.motokyi.lpk.ui.utils.UIUtils.HAND_CURSOR;
import static com.motokyi.lpk.ui.utils.UIUtils.findParentFrame;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class AddCredsButton extends JButton {

    public AddCredsButton(CredService credService) {
        super(PLUS_ICON);
        super.setCursor(HAND_CURSOR);
        super.addActionListener(e ->
                findParentFrame(this)
                        .ifPresent(frame -> new AddCredsDialog(credService, frame)));

    }
}
