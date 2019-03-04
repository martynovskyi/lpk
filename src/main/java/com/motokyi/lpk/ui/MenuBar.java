package com.motokyi.lpk.ui;

import javax.swing.*;

class MenuBar extends JMenuBar {

    MenuBar() {
        super();

        JMenu lpkMenu = new JMenu("LPK");
        super.add(lpkMenu);

        JMenu infoMenu = new JMenu("Info");
        super.add(infoMenu);
    }
}
