package com.motokyi.lpk.ui.utils;

import javax.swing.JLabel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.util.Objects.nonNull;

public class JLabelFactory {
    private static final String DEFAULT_EMPTY_TEXT = "-";
    private static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private JLabelFactory() {
    }

    public static JLabel of(LocalDateTime ldt) {
        if (nonNull(ldt)) {
            final JLabel label = new JLabel(FORMATTER.format(ldt));
            label.setToolTipText(ldt.toString());
            return label;
        }
        return new JLabel(DEFAULT_EMPTY_TEXT);
    }
}
