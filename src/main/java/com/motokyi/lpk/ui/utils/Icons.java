package com.motokyi.lpk.ui.utils;

import javax.swing.*;

public class Icons {
    public static final ImageIcon MORE_CHEVRON = new ImageIcon(Icons.class
            .getResource("/icons/1x/round_expand_more_black_48dp.png"));
    public static final ImageIcon LESS_CHEVRON = new ImageIcon(Icons.class
            .getResource("/icons/1x/round_expand_less_black_48dp.png"));
    private static final int SMALL_ICON_WIGHT = 24;
    private static final int SMALL_ICON_HEIGH = 24;
    public static final ImageIcon COPY = UIUtils.Graphics.scaleImageIcon(
            new ImageIcon(Icons.class.getResource("/icons/2x/round_file_copy_black_48dp.png")).getImage(),
            SMALL_ICON_WIGHT,
            SMALL_ICON_HEIGH);
    public static final ImageIcon EDIT = UIUtils.Graphics.scaleImageIcon(
            new ImageIcon(Icons.class.getResource("/icons/2x/round_edit_black_48dp.png")).getImage(),
            SMALL_ICON_WIGHT,
            SMALL_ICON_HEIGH);
    public static final ImageIcon DELETE = UIUtils.Graphics.scaleImageIcon(
            new ImageIcon(Icons.class.getResource("/icons/2x/round_delete_forever_black_48dp.png")).getImage(),
            SMALL_ICON_WIGHT,
            SMALL_ICON_HEIGH);
}
