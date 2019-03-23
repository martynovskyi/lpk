package com.motokyi.lpk.ui.utils;

import javax.swing.*;

public class Icons {
    private static final int CHEVRON_ICON_EDGE = 32;
    private static final int SMALL_ICON_EDGE = 24;

    public static final ImageIcon COPY = UIUtils.scaleImageIcon(
            new ImageIcon(Icons.class.getResource("/icons/2x/round_file_copy_black_48dp.png")),
            SMALL_ICON_EDGE, SMALL_ICON_EDGE);

    public static final ImageIcon EDIT = UIUtils.scaleImageIcon(
            new ImageIcon(Icons.class.getResource("/icons/2x/round_edit_black_48dp.png")),
            SMALL_ICON_EDGE, SMALL_ICON_EDGE);

    public static final ImageIcon DELETE = UIUtils.scaleImageIcon(
            new ImageIcon(Icons.class.getResource("/icons/2x/round_delete_forever_black_48dp.png")),
            SMALL_ICON_EDGE, SMALL_ICON_EDGE);

    public static final ImageIcon PLUS_ICON = UIUtils.scaleImageIcon(
            new ImageIcon(Icons.class.getResource("/icons/2x/round_add_black_48dp.png")),
            CHEVRON_ICON_EDGE, CHEVRON_ICON_EDGE);

    public static final ImageIcon MORE_CHEVRON = UIUtils.scaleImageIcon(
            new ImageIcon(Icons.class.getResource("/icons/2x/round_expand_more_black_48dp.png")),
            CHEVRON_ICON_EDGE, CHEVRON_ICON_EDGE);

    public static final ImageIcon LESS_CHEVRON = UIUtils.scaleImageIcon(
            new ImageIcon(Icons.class.getResource("/icons/2x/round_expand_less_black_48dp.png")),
            CHEVRON_ICON_EDGE, CHEVRON_ICON_EDGE);

}
