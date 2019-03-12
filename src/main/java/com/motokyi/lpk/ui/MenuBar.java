package com.motokyi.lpk.ui;

import javax.swing.*;

class MenuBar extends JMenuBar {

    MenuBar() {
        super();

        JMenu lpkMenu = new JMenu("LPK");

        lpkMenu.add("Save storage");
        lpkMenu.add("Exit");
        super.add(lpkMenu);

        JMenu infoMenu = new JMenu("Info");
        infoMenu.add("Storage info");
        infoMenu.add("About lpk");
        super.add(infoMenu);
    }
}
