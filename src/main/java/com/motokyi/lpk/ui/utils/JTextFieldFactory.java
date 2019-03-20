package com.motokyi.lpk.ui.utils;

import javax.swing.*;

public class JTextFieldFactory {

    public static JTextField disabledTextField(String text) {
        final JTextField textField = new JTextField(text);
        textField.setEditable(false);
        return textField;
    }

    public static JTextField disabledTextField(String name, String text) {
        final JTextField textField = new JTextField(text);
        textField.setName(name);
        textField.setEditable(false);
        return textField;
    }
}
