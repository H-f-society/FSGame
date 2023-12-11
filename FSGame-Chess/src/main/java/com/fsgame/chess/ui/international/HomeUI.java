package com.fsgame.chess.ui.international;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: root
 * @Date: 2023/12/11 16:54
 * @Description:
 */
public class HomeUI extends JFrame {

    private static final int UI_WIDTH = 600;
    private static final int UI_HEIGHT = 500;

    private JPanel jPanelLeft = new JPanel();
    private JPanel jPanelRight = new JPanel();

    public HomeUI() {
        this.setResizable(true);
        this.setSize(UI_WIDTH, UI_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void init() {
        this.setLayout(new BorderLayout());
        this.add(jPanelLeft, BorderLayout.EAST);
        this.add(jPanelRight, BorderLayout.WEST);
    }
}
